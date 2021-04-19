package com.lwdHouse.ba01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
public class School {
    @Value("PolyU")
    private String name;
    @Value("hongkan")
    private String address;

    public String toString() {
        return "school{" + 
                "name='" + name + "'" +
                ", address='" + address + "'" + 
                "}";
    }
}