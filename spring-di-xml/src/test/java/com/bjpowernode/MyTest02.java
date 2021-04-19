package com.bjpowernode;

import com.bjpowernode.ba02.Student;
import com.bjpowernode.ba02.School;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    private Object bean;

	@Test
    public void test02() {
        School mySchool = new School("PolyU", "hongKan");
        Student myStudent = new Student();
        myStudent.setName("lwd");
        myStudent.setAge(20);
        myStudent.setSchool(mySchool);
        System.out.println("mystudent:"+myStudent);
    }

    @Test
    public void test03(){
        String config = "ba02/applicationContext.xml";
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