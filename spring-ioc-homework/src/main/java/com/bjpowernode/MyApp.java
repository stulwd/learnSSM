package com.bjpowernode;

import com.bjpowernode.domain.SysUser;
import com.bjpowernode.service.UserService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        UserService us = (UserService) ac.getBean("userService");
        SysUser user1 = new SysUser();
        user1.setId(100);
        user1.setName("lwd");
        us.addUser(user1);
    }
}