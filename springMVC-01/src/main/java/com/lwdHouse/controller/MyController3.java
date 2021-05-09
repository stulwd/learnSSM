package com.lwdHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * controller创建的对象会放到springmvc容器中
 *
 * 能处理请求的都是控制器（处理器）：MyController能处理请求，叫做后端控制器（back controller）
 */
@Controller
@RequestMapping(value = "/user1")
public class MyController3 {

//    如果要将doSome映射到localhost:port/工程名/user/some.do, 要这样写
//    @RequestMapping(value = {"/user/some.do", "/user/first.do"})
//    但是如果给MyController2类加RequestMapping注解，那么方法的RequestMapping的value可以省去公共的前缀
    @RequestMapping(value = {"/some.do"}, method = {RequestMethod.GET})
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是dosome()方法");
        mv.setViewName("show");
        return mv;
    }

//    因为/user1/other.do只支持POST请求，所以在浏览器地址栏敲
//    http://localhost:8080/springMVC/user1/other.do
//    来直接访问，会报：HTTP状态 405 - GET方法不允许
    @RequestMapping(value = {"/other.do"}, method = {RequestMethod.POST})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }

//    不指明method，那么get和post都支持
    @RequestMapping(value = {"/first.do"})
    public ModelAndView doFirst(HttpServletRequest request,
                                HttpServletResponse response,
                                HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用spring "+request.getParameter("name"));
//      可以直接访问:  http://localhost:8080/springMVC/user1/first.do?name=liuwendi
        mv.addObject("fun", "执行的是doFirst方法");
        mv.setViewName("other");
        return mv;
    }

}
