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
@RequestMapping(value = "/user")
public class MyController2 {

//    如果要将doSome映射到localhost:port/工程名/user/some.do, 要这样写
//    @RequestMapping(value = {"/user/some.do", "/user/first.do"})
//    但是如果给MyController2类加RequestMapping注解，那么方法的RequestMapping的value可以省去公共的前缀
    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎使用springmvc做web开发");
        mv.addObject("fun", "执行的是dosome()方法");
        mv.setViewName("show");
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
