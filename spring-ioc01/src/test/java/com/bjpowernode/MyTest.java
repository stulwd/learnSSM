package com.bjpowernode;

import java.util.Date;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.impl.SomeServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


public class MyTest {
    @Test
    public void test01() {
        final SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void test02() {
        final String config = "beans.xml";
        final ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        final SomeService service = (SomeService) ac.getBean("someService2");
        final SomeService service2 = (SomeService) ac.getBean("someService2");
        // service.doSome();
        int nums = ac.getBeanDefinitionCount();
        System.out.println("容器中的对象数量：" + nums);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
                System.out.println(name);
        }
        
        Date my = (Date) ac.getBean("mydate");
        System.out.println("Date: " + my);
    }
}