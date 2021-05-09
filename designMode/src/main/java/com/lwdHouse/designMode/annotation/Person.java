package com.lwdHouse.designMode.annotation;

import com.lwdHouse.designMode.myEnum.Gender;

@MyAnnotation(name = "zhangsan", age=30)
public class Person {

    @MyAnnotation2(value = "abc", num = 12, class1 = String.class,
            gender = Gender.FEMALE,
            annotation = @MyAnnotation())
    @MyAnnotation(name="张三", age=20)
    public void show() {
    }

    @PersonInfo(name = "小岳岳", age = 20, sex = "male")
    public void show2(String name, int age, String sex) {
        System.out.println("name:"+name+" age"+age+" sex:"+sex);
    }
}