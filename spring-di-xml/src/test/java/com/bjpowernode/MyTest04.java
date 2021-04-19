package com.bjpowernode;

import com.bjpowernode.ba04.Student;
import com.bjpowernode.ba04.School;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    private Object bean;

    @Test
    public void test03(){
        String config = "ba04/applicationContext.xml";
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