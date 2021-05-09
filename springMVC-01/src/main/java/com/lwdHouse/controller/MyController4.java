package com.lwdHouse.controller;

import com.lwdHouse.vo.IdCard;
import com.lwdHouse.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller创建的对象会放到springmvc容器中
 *
 * 能处理请求的都是控制器（处理器）：MyController能处理请求，叫做后端控制器（back controller）
 */
@Controller
public class MyController4 {

    /**
     * 请求参数
     * 1.使用HttpServletRequest来接受，参考MyController3
     * 2.用参数名作为形参名来接受参数，要保证参数名和形参名一致
     *      浏览器发送过来的数据都是String类型，但是型参类型可以是数字类型，因为框架会做类型转换的，
     *   比如形参为 Integer age，那么实参会取Integer.valueOf(传过来的age字符串)值，在这个过程中，如果
     *   传过来的age字符串内容不是数字，转换会报错 400
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveProperty.do")
    public ModelAndView receiveProperty(String name, int age){
        ModelAndView mv = new ModelAndView();
        System.out.println("name:"+name);
        System.out.println("age:"+age);
//        如果是post请求，会有乱码, 上面两行打印如下
//        get请求：
//          name:刘
//          age:123
//        post请求:
//          name:??????è??
//          age:123
//        解决办法：
//          在web.xml中注册声明过滤器，解决post乱码问题
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show2");

        return mv;
    }

    /**
     * 请求参数
     * 如果参数名和形参名不一致，可以使用RequestParam注解来修正：
     * RequestParam的required表示此参数是否必须要有，
     * 要为true，如果请求中没有这个参数，会报错
     * 要是为false，请求中可以没有这个参数，到时候会赋一个null
     * 因为简单类型的值不能为null，所以参数类型必须是对象类型，才可以是null值，
     * 所以required = false对简单类型不奏效
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveProperty2.do")
    public ModelAndView receiveProperty2(@RequestParam("rname") String name,
                                         @RequestParam(value = "rage", required = false) Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show2");

        return mv;
    }

    /**
     * 请求参数：
     * 3.对象接受参数
     * 原理：
     * 假如请求参数是name1，name2
     * 框架会先创建一个形参类型的对象obj，然后依次调用
     * obj1.setName1()，obj1.setName2()方法，然后把这个对象当做实参赋给形参
     * @return
     */
    @RequestMapping(value = "/receiveProperty3.do")
    public ModelAndView receiveProperty3(Student student, IdCard idCard){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", student.getName());
        mv.addObject("myAge", student.getAge());
        mv.addObject("student", student);
        mv.addObject("idCard", idCard);
        idCard.setId(14024237);
        mv.setViewName("show3");
        return mv;
    }
}
