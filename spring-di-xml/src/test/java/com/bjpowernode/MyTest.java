package com.bjpowernode;

import java.util.Date;

import com.bjpowernode.ba01.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("student对象="+myStudent);
        myStudent.setAge(31);
        System.out.println("getAge:"+myStudent.getAge());

        Date myDate = (Date) ac.getBean("mydate");
        System.out.println("mydate:"+myDate);
    }
}