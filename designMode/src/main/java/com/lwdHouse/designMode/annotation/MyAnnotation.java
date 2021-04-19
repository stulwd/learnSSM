package com.lwdHouse.designMode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface MyAnnotation {
    // 属性
    String name() default "张三";
    int age() default 18;
}