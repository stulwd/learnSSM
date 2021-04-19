package com.lwdHouse.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.lwdHouse.util.ServiceTools;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;
    
    
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("jdk自动代理实现");
        System.out.println("调用的方法:"+method.getName());
        Object res = null;
        // 只有doSome方法才执行doLog
        if ("doSome" == method.getName()) {
            ServiceTools.doLog();
        }
        res = method.invoke(target, args);
        ServiceTools.doTrans();
        System.out.println("\n");
        return res;
    }


    
}