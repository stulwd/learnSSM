package com.lwdHouse.designMode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import com.lwdHouse.designMode.factory.UsbFactory;
import com.lwdHouse.designMode.service.Usb;

public class app {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println("请选择：");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        Usb u1 = UsbFactory.createUsb(choice);
        if (u1 != null) {
            u1.service();
        } else {
            System.out.println("无效选择");
        }

        FileInputStream fis = new FileInputStream("./designMode/target/classes/usb.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String type = prop.getProperty(String.valueOf(choice));
        u1 = UsbFactory.createUsb2(type);
        if (u1 != null){
            u1.service();
        }else {
            System.out.println("购买失败");
        }

        input.close();

    }

}