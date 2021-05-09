package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "redirectServlet2", value = "/redirectServlet2")
public class redirectServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("redirectServlet2's result");
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        System.out.println("redirectServlet2的key1属性值："+request.getAttribute("key2"));
//        不共享数据域，所以获取到的key1为null
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
