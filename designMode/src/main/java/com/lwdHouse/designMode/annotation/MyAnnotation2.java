package com.lwdHouse.designMode.annotation;

import com.lwdHouse.designMode.myEnum.Gender;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD})
public @interface MyAnnotation2 {
    String value();
    int num() default 20;
    Class<?> class1();
    Gender gender();
    MyAnnotation annotation();
    // ArrayList<String> list();
}