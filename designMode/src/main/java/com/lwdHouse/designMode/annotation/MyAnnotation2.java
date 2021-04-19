package com.lwdHouse.designMode.annotation;

import com.lwdHouse.designMode.myEnum.Gender;

public @interface MyAnnotation2 {
    String value();
    int num() default 20;
    Class<?> class1();
    Gender gender();
    MyAnnotation annotation();
    // ArrayList<String> list();
}