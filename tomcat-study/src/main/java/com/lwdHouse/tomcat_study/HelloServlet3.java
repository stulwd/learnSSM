package com.lwdHouse.tomcat_study;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("重写init方法，做一些工作");
        super.init(config);
//        如果重写了init(ServletConfig config)方法，最后一定要调用父类的init(config)方法,
//        因为这个方法会把config对象赋值servlet的config属性
//        一般不要重写这个带参方法，而是重写init()即可，原因参考init(ServletConfig config)方法源码
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet3 的doGet方法");
        ServletConfig servletConfig = getServletConfig();
//        获取servlet程序的别名servlet-name的值
        System.out.println("helloServlet2程序的别名是："+ servletConfig.getServletName());
//        2.获取初始化参数init-param
        System.out.println("helloServlet2的初始化参数username："+ servletConfig.getInitParameter("username"));
        System.out.println("helloServlet2的初始化参数url："+ servletConfig.getInitParameter("url"));
//        3.获取servletContext对象
        System.out.println("helloServlet2的context："+servletConfig.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet3 的doPost方法");
    }
}
