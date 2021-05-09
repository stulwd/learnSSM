package com.lwdHouse.controller;


import com.lwdHouse.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/some")
    public ModelAndView doSome(Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",student.getName());
        mv.addObject("myAge", student.getAge());
        mv.setViewName("show2");

        return mv;
    }
}
