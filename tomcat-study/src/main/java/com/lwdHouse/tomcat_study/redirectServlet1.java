package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "redirectServlet1", value = "/redirectServlet1")
public class redirectServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("曾到此一游 redirectServlet1");
//        设置请求重定向的2种方法：
//        方法1：
        response.setStatus(302);
//        域数据不能共享
        request.setAttribute("key1", "value1");
        System.out.println("redirectServlet1的key1属性值：" + request.getAttribute("key1"));
        response.setHeader("Location", "http://localhost:8088/helloWeb/redirectServlet2");
//        可以访问域外资源
//        response.setHeader("Location", "http://www.baidu.com");
//        不能访问受保护目录，会返回404
//        response.setHeader("Location", "http://localhost:8088/helloWeb/WEB-INF/web.xml");
//        请求重定向的特点：
//        1.浏览器的地址会发生变化
//        2.两次请求
//        3.不共享Request域中的数据

//        方法2：
//        response.sendRedirect("http://localhost:8088/helloWeb/redirectServlet2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
