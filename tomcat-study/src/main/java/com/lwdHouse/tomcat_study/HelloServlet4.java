package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet4 extends HttpServlet {
//      当tomcat启动后，会输出：
//        Using CATALINA_BASE:   "C:\Users\wendi\AppData\Local\JetBrains\IntelliJIdea2021.1\tomcat\b0116c6d-2470-4657-a839-63eb7d569417"
//              CATALINA_BASE 是 tomcat被拷贝的一些副本内容
//               C:\Users\wendi\AppData\Local\JetBrains\IntelliJIdea2021.1\tomcat\b0116c6d-2470-4657-a839-63eb7d569417\conf\Catalina\localhost\helloWeb.xml
//               里存放了web路径和工程实际路径的映射关系：
//                  <Context path="/helloWeb" docBase="C:\Users\wendi\Desktop\spring\spring-framework-study\tomcat-study\target\tomcat-study-1.0-SNAPSHOT" />
//        Using CATALINA_HOME:   "D:\Program Files\tomcat\apache-tomcat-9.0.45"
//        Using CATALINA_TMPDIR: "D:\Program Files\tomcat\apache-tomcat-9.0.45\temp"
//        Using JRE_HOME:        "D:\Program Files\jdk-11"
//        Using CLASSPATH:       "D:\Program Files\tomcat\apache-tomcat-9.0.45\bin\bootstrap.jar;D:\Program Files\tomcat\apache-tomcat-9.0.45\bin\tomcat-juli.jar"
//        Using CATALINA_OPTS:   ""
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext的作用
//        1.获取web.xml中配置的上下文参数context.param
        ServletContext context = getServletContext();
//        所有servlet的context对象都一样
        System.out.println("HelloServlet4 context hash:"+context.hashCode());
//        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("context-param参数username的值是："+username);
        System.out.println("context-param参数password的值是："+password);
        System.out.println("当前工程路径是："+ context.getContextPath());
//        2.获取当前工程路径，格式：/工程路径
//        / 被服务器解析的地址为http://ip:port/工程名/
        System.out.println("当前工程部署路径是："+ context.getRealPath("/"));
//      C:\Users\wendi\Desktop\spring\spring-framework-study\tomcat-study\target\tomcat-study-1.0-SNAPSHOT\
        System.out.println("当前工程部署路径是："+ context.getRealPath("/css"));
        System.out.println("当前工程部署路径是："+ context.getRealPath("/imgs/1.jpg"));

        System.out.println("保存之前："+ context.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println("HelloServlet4 中获取域数key1的值是："+ context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
