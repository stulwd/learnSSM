package com.lwdHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.lwdHouse.handler.MyInvocationHandler;
import com.lwdHouse.service.SomeService;
import com.lwdHouse.service.SomeServiceImpl;
import com.lwdHouse.service.Student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        /**
         * jdk动态代理，jdk动态代理实际代理的是接口类
         */
//         SomeService target = new SomeServiceImpl();
//         InvocationHandler handler = new MyInvocationHandler(target);
//         // for (Class cla : target.getClass().getInterfaces()) {
//         //     System.out.println(cla);
//         // }
//         // System.out.println(target.getClass().getInterfaces());
//         // System.out.println(target.getClass().getClassLoader());
//         SomeService serviceProxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
//                                                     target.getClass().getInterfaces(),
//                                                     handler);
//         System.out.println("proxy:"+serviceProxy.getClass());
//         serviceProxy.doSome("liuwendi", 24);
//         serviceProxy.doOther("liuwendi", 24);



        
         
        /**
         * aspectj-aop方式
         */
//
//         String config = "applicationContext.xml";
//         ApplicationContext ac = new ClassPathXmlApplicationContext(config);
//         SomeService proxy = (SomeService) ac.getBean("someService");
//         System.out.println("proxy:"+proxy.getClass());
        // 切入点表达式匹配到了就会是代理类：proxy:class com.sun.proxy.$Proxy15
        // 切入点表达式没有匹配到就是原有类：proxy:class com.lwdHouse.SomeServiceImpl

        // @Before
        // proxy.doSome("liuwendi", 24);
        // @AfterReturning
        // String res = proxy.doOther("liuwendi", 24);
        // System.out.println("res:"+res);
        // @AfterReturning
        // Student stu = proxy.doOther2("liuwendi", 24);
        // System.out.println("切面执行完成后的stu:"+stu);
        // @Around
        // String doFirst = proxy.doFirst("liuwendi", 18);
        // @AfterThrowing @After
        // proxy.doSecond(0);
 





        /**
         * jdk动态代理和cglib动态代理
         * cglib动态代理：
         *      不需要目标类有接口
         * jdk动态代理：
         *      需要目标类有接口
         */
        // 目标类如果有接口，采用jdk的动态代理
        // 目标类没有接口，用cglib代理
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 如果使用cglib代理，返回的bean就是SomeServiceImpl类型，所以返回值可以转换为SomeServiceImpl或者接口类型
        SomeService proxy = (SomeService) ac.getBean("someService");
        // 如果使用jdk代理，返回的bean不能赋给SomeServiceImpl类型，只能赋值给接口类型
        // SomeService proxy = (SomeService) ac.getBean("someService");
        System.out.println("proxy:"+proxy.getClass());
    }
}