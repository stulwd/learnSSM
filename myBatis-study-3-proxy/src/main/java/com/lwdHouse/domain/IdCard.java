package com.lwdHouse.domain;

public class IdCard {
    String name;
    int account;
    String gender;
    String hobby;
    String address;

    @Override
    public String toString() {
        return "MyStudent{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}