package com.lwdHouse.controller;

import com.lwdHouse.service.BuyGoods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        String strAmount = request.getParameter("amount");

//         创建spring容器对象
//        String config = "applicationContext.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        如果每一次有访问都会创建容器，那会占用资源过大，可以在监听器中创建
        WebApplicationContext ctx = null;
        ServletContext sc = getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println("容器对象信息========"+ctx);
        //获取service
        BuyGoods service = (BuyGoods) ctx.getBean("buyGoodsImpl");
        service.buy(Integer.valueOf(strId), Integer.valueOf(strAmount));

        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
