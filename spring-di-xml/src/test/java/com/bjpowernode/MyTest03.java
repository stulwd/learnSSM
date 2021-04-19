package com.bjpowernode;

import java.io.File;

import com.bjpowernode.ba03.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test03(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // school的无参构造
        // setNamepolyU
        // setAddresshongkan
        // student参数构造
        // mystudent:String{name='张三', age=20, school=school{name='polyU', address='hongkan'}}
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("mystudent:"+myStudent);
        myStudent = (Student) ac.getBean("myStudent1");
        System.out.println("mystudent:"+myStudent);
        myStudent = (Student) ac.getBean("myStudent2");
        System.out.println("mystudent:"+myStudent);

        File file = (File) ac.getBean("myFile");
        System.out.println("file:"+file.getName());
    }
}