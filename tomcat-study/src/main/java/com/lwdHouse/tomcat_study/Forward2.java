package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Forward2", value = "/hello8")
public class Forward2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("在Forward2中查看参数："+username);

        String key1 = (String) request.getAttribute("key");
        System.out.println("柜台1是否有章："+key1);

        System.out.println("处理Forward2自己的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
