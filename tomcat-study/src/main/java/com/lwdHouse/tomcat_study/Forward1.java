package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Forward1", value = "/hello7")
public class Forward1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("在Forward1中查看参数："+username);

        request.setAttribute("key", "柜台1的章");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello8");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/a/b/d.jsp");
//        转发到ROOT
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");
//        使用转发还可以访问WEB-INF下面的内容，正常情况下，浏览器不能直接访问此目录的内容
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/web.xml");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://www.baidu.com");
//        报错：请求的资源[/helloWeb/http://www.baidu.com]不可用
        requestDispatcher.forward(request, response);

//        请求转发的特点：
//        1.浏览器的地址没有变化
//        2.他们是一次请求
//        3.他们共享request域中的数据
//        4.可以转发到WEB-INF目录下
//        5.不能访问工程以外的资源
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
