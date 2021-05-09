package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "respServlet", value = "/respServlet")
public class respServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

//         不能既使用getwriter()又使用getOutputStream()方法，会报错
//         response.getOutputStream();
        PrintWriter pw = response.getWriter();
        pw.write("response's contect!!!");

        System.out.println("response的字符编码："+response.getCharacterEncoding());
//         response的字符编码：ISO-8859-1
        pw.write("国哥很帅");           // 浏览器会显示成????
//         所以要用Content-Type header来指定编码格式
//        response.setHeader("Content-Type", "text/html; charset=UTF-8");
//         或者用以下方法指定也可以
        response.setContentType("text/html; charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
