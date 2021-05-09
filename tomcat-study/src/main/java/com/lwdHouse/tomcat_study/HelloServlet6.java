package com.lwdHouse.tomcat_study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * http协议的格式：
 * 1.GET请求
 *   1）请求行 例如：GET /helloWeb/hello6  HTTP/1.1
 *      - 请求的方式                       GET
 *      - 请求的资源路径（+？+请求参数）
 *      - 请求的协议版本号                  HTTP/1.1
 *   2) 请求头
 *      key：value组成
 *      - Accept: 告诉服务器，客户端可以接受的数据类型
 *      - Accept-Language: 告诉服务器，客户端可以接受的语言类型
 *              zh-CN
 *              en-US
 *      - User-Agent: 浏览器的信息
 *      - Accept-Encoding: 客户端可以接受的编码格式
 *      - Host: 请求的服务器ip和端口号
 *      - Connection: 告诉服务器连接如何处理
 *          Keep-Alive
 *          Closed
 * 2.POST请求
 *   1）请求行 POST /XXX/XXX HTTP/1.1
 *   2）请求头 key: value
 *   空行
 *   3）请求体 ======》发送给服务器的数据
 *
 * 例如访问 a.html 页面，点击提交后发送的数据
 *  （请求行）  POST /helloWeb/hello6 HTTP/1.1
 *  （请求头）  Host: localhost:8088
 *            Connection: keep-alive
 *            Content-Length: 26
 *            Cache-Control: max-age=0
 *            sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="90", "Google Chrome";v="90"
 *            sec-ch-ua-mobile: ?0
 *            Upgrade-Insecure-Requests: 1
 *            Origin: http://localhost:8088
 *            Content-Type: application/x-www-form-urlencoded
 *            User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36
 *            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,,application/signed-exchange;v=b3;q=0.9
 *            Sec-Fetch-Site:same-origin
 *            Sec-Fetch-Mode:navigate
 *            Sec-Fetch-User:?1
 *            Sec-Fetch-Dest:document
 *            Referer:http://localhost:8088/helloWeb/a.html
 *            Accept-Encoding:gzip,deflate,br
 *            Accept-Language:zh-CN,zh;q=0.9
 *            Cookie:JSESSIONID=6C117D2FA637F841B01C25A69D4E0FD2
 *   空行
 *  （请求体）  action=login&username=root
 *
 * 服务器返回：
 *    响应行     HTTP/1.1 200          （响应的协议格式 + 响应码）
 *    响应头     Content-Length: 0
 *              Date: Sun, 02 May 2021 13:55:35 GMT
 *              Keep-Alive: timeout=20
 *              Connection: keep-alive
 *    空行
 *    响应体
 *              html页面
 *
 * 3. 哪些是GET请求？
 *      1）form标签 method=get
 *      2）a 标签
 *      3）link标签引入css
 *      4）script标签引入js文件
 *      5）img标签引入图片
 *      6）iframe引入html
 *      7）浏览器地址栏中输入网址敲回车
 * 4. 哪些是POST请求?
 *      1) form标签 method=post
 *
 * 5. 常用的响应码说明
 *      200 成功
 *      302 请求重定向
 *      404 服务器已经收到了，但是你要的数据不存在（请求地址错误）
 *      500 服务器已经收到请求，但是服务器内部错误（代码错误）
 *
 */


@WebServlet(name = "HelloServlet6", value = "/hello6")
public class HelloServlet6 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet6初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        System.out.println("HelloServlet6 context hash:"+context.hashCode());
//        int i = 12 / 0;         // 会返回500错误 消息： by zero
//        httpServletRequest类的常用方法
//        1.getRequestURI()
        System.out.println("URI => "+ req.getRequestURI());    // 获取请求的资源路径
//        /helloWeb/hello6
        System.out.println("URL => "+ req.getRequestURL());    // 获取请求的同意资源定位符
//        http://localhost:8088/helloWeb/hello6
        System.out.println("客户端的ip => "+ req.getRemoteHost());    // 获取客户端的ip
//        0:0:0:0:0:0:0:1
        System.out.println("User-Agent => "+ req.getHeader("User-Agent"));   // 获取请求头
//        Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36
        System.out.println("method => "+ req.getMethod());        // 获取请求方法
//        GET
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String hobby = req.getParameter("hobby");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");      // 不设置编码，post请求的中文字符会出现乱码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));
    }
}
