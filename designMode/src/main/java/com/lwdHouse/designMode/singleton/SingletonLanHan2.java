package com.lwdHouse.designMode.singleton;

public class SingletonLanHan2 {
    private SingletonLanHan2() {};
    
    private static class holder {
        static SingletonLanHan2 instance = new SingletonLanHan2();
    }

    public SingletonLanHan2 getInstance() {
        return holder.instance;
    }
}