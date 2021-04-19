package com.lwdHouse.domain;

public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private void privateMethod(String str) {
        System.out.println("调用了privateMethod，入参是"+ str);
    }

    public static void staticMethod() {
        System.out.println("调用了静态方法");
    }

    public void fun1(Integer num) {
        System.out.println("调用了fun1方法，参数："+ num);
    }
    public void fun2(String str, Integer num) {
        System.out.println("调用了fun2方法，参数："+ str + " " + num);
    }
}