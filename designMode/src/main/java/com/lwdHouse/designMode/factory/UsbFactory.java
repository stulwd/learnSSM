package com.lwdHouse.designMode.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.lwdHouse.designMode.service.Usb;
import com.lwdHouse.designMode.service.impl.Fan;
import com.lwdHouse.designMode.service.impl.Mouse;
import com.lwdHouse.designMode.service.impl.Upan;


public class UsbFactory {
    public static Usb createUsb(int type) {
        Usb usb = null;
        if (type == 1) {
            usb = new Fan();
        } else if (type == 2) {
            usb = new Mouse();
        }else if (type == 3) {
            usb = new Upan();
        }
        return usb;
    }

    // 上面的方法不满足开闭原则，即对新增开放，对修改关闭
    public static Usb createUsb2(String type) {
        Usb usb = null;
        try {
            Class<?> cla = Class.forName(type);
            Constructor<?> con = cla.getConstructor();
            usb = (Usb) con.newInstance();
        } catch (Exception e) {
            System.out.println("创建失败");
            return usb;
        }
        return usb;
    }
}