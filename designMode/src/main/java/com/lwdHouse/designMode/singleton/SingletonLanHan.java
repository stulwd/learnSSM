package com.lwdHouse.designMode.singleton;

public class SingletonLanHan {
    private static SingletonLanHan instance = null;
    private SingletonLanHan() {};

    /**
     * 懒汉式单例，线程不安全
     * @return
     */
    public static SingletonLanHan getInstance() {
        if (instance == null) {
            instance = new SingletonLanHan();
        }
        return instance;
    }

    // 以下依次是线程安全的改进
    public static synchronized SingletonLanHan getInstance2() {
        if (instance == null) {
            instance = new SingletonLanHan();
        }
        return instance;
    }
    public static SingletonLanHan getInstance3() {
        synchronized (SingletonLanHan.class){
            if (instance == null) {
                instance = new SingletonLanHan();
            }
        }
        return instance;
    }
    // 提高效率
    public static SingletonLanHan getInstance4() {
        if (instance == null) {
            synchronized (SingletonLanHan.class){
                if (instance == null) {
                    instance = new SingletonLanHan();
                }
            }
        }
        return instance;
    }

}