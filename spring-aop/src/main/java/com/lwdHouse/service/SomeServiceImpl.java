package com.lwdHouse.service;

import org.springframework.stereotype.Component;

// 目标类
@Component(value = "someService")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // TODO Auto-generated method stub
        System.out.println("=====目标方法的doSome()=====");
    }

    @Override
    public String doOther(String name, Integer age) {
        // TODO Auto-generated method stub
        System.out.println("=====目标方法的doOther()=====");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        // TODO Auto-generated method stub
        System.out.println("=====目标方法的doOther2()=====");
        Student stu = new Student(name, age);
        System.out.println("创建的student对象: " + stu);
        return stu;
    }

    @Override
    public String doFirst(String name, Integer age) {
        // TODO Auto-generated method stub
        System.out.println("=====目标方法的doFirst()=====");
        return "doFirst";
    }

    @Override
    public void doSecond(Integer num) {
        // TODO Auto-generated method stub
        System.out.println("=====目标方法的doSecond()=====");
        System.out.println("计算100 / "+num+" = " + 100/num);
    }

}