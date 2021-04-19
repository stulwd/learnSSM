package com.lwdHouse.designMode.singleton;

/**
 * 饿汉式单例
 */
public class SingletonEHan {
    private SingletonEHan(){};
    // 这个instance必须是static的，保存在类中的，否则会造成内存溢出
    private static final SingletonEHan instance = new SingletonEHan();
    public static SingletonEHan getInstance(){
        return instance;
    }
}