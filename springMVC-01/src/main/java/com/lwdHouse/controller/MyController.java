package com.lwdHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller创建的对象会放到springmvc容器中
 *
 * 能处理请求的都是控制器（处理器）：MyController能处理请求，叫做后端控制器（back controller）
 */
@Controller
public class MyController {

    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
//        添加数据, 框架在请求的最后把数据会放入request作用域
//        request.setAttribute("msg", "欢迎使用springmvc做web开发");
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是dosome()方法");

//        指定视图，相当于request.getRequestDispatcher("/show.jsp").forward()
//        mv.setViewName("/show.jsp");
//        因为是相当于forward请求转发，所以可以访问受保护的目录
//        mv.setViewName("/WEB-INF/view/show.jsp");

//        可以在springmvc.xml配置文件设置视图解析器，设置之后，可以直接访问
        mv.setViewName("show");
//        注意，设置了视图解析器后，上面的通过全路径访问就会出错
//        例如第二个会报找不到/WEB-INF/view/WEB-INF/view/show.jsp.jsp的错误

        // 返回mv, 在后期会做上面的那些操作
        return mv;
    }

    @RequestMapping(value = {"/other.do", "/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }
}
