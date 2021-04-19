package com.bjpowernode.ba01;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("student的无参构造");
    }

    public void setEmail(String email) {
        System.out.println("setEmail="+email);
    }

    /** 
     * @param name the name to set
     */
    public void setName(String name) {
        System.out.println("setName"+name);
        this.name = name.toUpperCase();
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        System.out.println("setAge:"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "String{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

}