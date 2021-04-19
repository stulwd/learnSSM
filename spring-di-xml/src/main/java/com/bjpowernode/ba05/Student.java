package com.bjpowernode.ba05;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student() {
        System.out.println("student的无参构造");
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        System.out.println("setSchool"+name);
        this.school = school;
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
                ", school=" + school +
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