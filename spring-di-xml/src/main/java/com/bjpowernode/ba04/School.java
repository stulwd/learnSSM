package com.bjpowernode.ba04;

public class School {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("setAddress"+address);
        this.address = address;
    }

    public void setName(String name) {
        System.out.println("setName"+name);
        this.name = name;
    }

    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public School() {
        System.out.println("school的无参构造");
    }

    public String toString(){
        return "school{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';

    }
}