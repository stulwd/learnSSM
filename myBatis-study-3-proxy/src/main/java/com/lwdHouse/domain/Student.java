package com.lwdHouse.domain;

public class Student {
    String name;
    int id;
    int age;
    String sex;

    public Student(){};

    public Student(String name, int id, int age, String sex) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

	@Override
	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
}