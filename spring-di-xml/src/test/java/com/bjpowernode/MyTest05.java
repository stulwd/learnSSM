package com.bjpowernode;

import com.bjpowernode.ba05.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    private Object bean;

    @Test
    public void test03(){
        String config = "ba05/applicationContext.xml";
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