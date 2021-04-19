package com.bjpowernode;

import com.bjpowernode.ba06.Student;
import com.bjpowernode.ba06.School;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {
    private Object bean;

    @Test
    public void test03(){
        String config = "ba06/total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // student的无参构造
        // school的无参构造
        // setNamepolyU
        // setAddresshongkan
        // setName李四
        // setAge:20
        // setSchool李四
        // 可见先调用无参构造，再注入
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("mystudent:"+myStudent);
    }
}