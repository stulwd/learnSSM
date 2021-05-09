package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet2 implements Servlet {

    public HelloServlet2() {
        System.out.println("HelloServlet的构造方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet被初始化");
//        获取servlet程序的别名servlet-name的值
        System.out.println("helloServlet2程序的别名是："+ servletConfig.getServletName());
//        2.获取初始化参数init-param
        System.out.println("helloServlet2的初始化参数username："+ servletConfig.getInitParameter("username"));
        System.out.println("helloServlet2的初始化参数url："+ servletConfig.getInitParameter("url"));
//        3.获取servletContext对象
        System.out.println("helloServlet2的context："+servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello servlet被访问了");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            System.out.println("get请求");
        } else {
            System.out.println("post请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁了");
    }
}
