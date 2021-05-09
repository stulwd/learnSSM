package com.lwdHouse;

import com.lwdHouse.ba01.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        System.out.println(ac.getBeanDefinitionCount());
        String[] beans = ac.getBeanDefinitionNames();
        for (String bean :
                beans) {
            System.out.println("bean name:" + bean);
        }
        Student student = (Student) ac.getBean("student");
        System.out.println("student="+student);
    }
}