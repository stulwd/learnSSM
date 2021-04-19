package com.lwdHouse.designMode.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface PersonInfo {
    String name();
    int age();
    String sex();
}