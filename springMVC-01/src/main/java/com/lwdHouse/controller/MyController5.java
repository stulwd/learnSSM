package com.lwdHouse.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwdHouse.vo.Student;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController5 {

    /**
     * 返回类型：
     * 1.处理器方法返回string-表示逻辑视图名称，需要配置视图解析器，已经在springmvc.xml中配置
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name, Integer age){
        System.out.println("doReturnView, name="+name+"  age="+age);
//        可以自己手工添加数据到request作用域
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);
        request.setAttribute("student", "liuwendi");
        request.setAttribute("idCard", "14024237");
//        框架最终会对视图执行forward转发操作
        return "show3";
//        如果返回的是完整路径，就不能配置视图解析器
//        return "/WEB-INF/view/show3.jsp";
    }

    /**
     * 返回类型：
     * 2.处理器方法返回void，响应ajax请求
     * @param
     * @param name
     * @param age
     */
    @RequestMapping("returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
//        1.调用service处理业务逻辑
        System.out.println("===doReturnVoidAjax===, name="+name+" age="+age);
        Student student = new Student();
        student.setAge(age);
        student.setName(name);

//        2.转成json字符串
        String json = "";
        if(student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json: "+json);
        }

//        3.写response
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

    /**
     * 返回类型：
     * 3.返回对象（object，String，Integer，Map）类型，响应ajax请求
     *  1). 加入处理json的工具库依赖jackon
     *  2). 在spring配置文件中加入<mvc:annotation-driven>注解驱动: 完成的功能是java对象到json, xml, text, 二进制数据的转换。
     *      HttpMessageConveter接口：消息转换器
     *      这个接口定义了java对象到各个类型转换的方法，这个接口有很多实现类，完成java对象到各个类型（xml，json，二进制数据）的转换
     *      json = om.writeValueAsString(Student)
     *  3). 在处理器方法上面加入@ResponseBody注解
     *      response.setContentType("application/json;charset=utf-8")
     *      response.getWriter().println(json);
     *
     *  返回对象框架的处理流程
     *  1. 框架会把返回Student类型，调用框架中ArrayList<HttpMessageConverter>中每个类的canWrite()方法检查哪个
     *     HttpMessageConverter接口的实现类能处理Student类型的数据---MappingJackson2HttpMessageConverter
     *
     *  2. 框架调用MappingJackson2HttpMessageConverter.write()方法，把student对象转为json，调用jackson的
     *  ObjectMapper实现转为json
     *
     *  3. 框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成
     * @return
     */
    @ResponseBody
    @RequestMapping("returnJsonObj.do")
    public Student doReturnJsonObj(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student; // 会被框架转为json
    }

    /**
     * 返回类型
     * 4.返回List
     * @param name
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping("doReturnJsonObjArray.do")
    public List<Student> doReturnJsonObjArray(String name, Integer age){
        List<Student> ls = new ArrayList<>();
        Student stu1 = new Student();
        Student stu2 = new Student();
        stu1.setAge(10);
        stu1.setName("小东");
        stu2.setAge(20);
        stu2.setName("小北");
        ls.add(stu1);
        ls.add(stu2);

        return ls;
    }

    /**
     * 返回类型
     * 5.字符串数据
     *      必须要使用produces指定编码格式
     *  返回对象框架的处理流程
     *  1. 框架会把返回String类型，调用框架中ArrayList<HttpMessageConverter>中每个类的canWrite()方法检查哪个
     *     HttpMessageConverter接口的实现类能处理String类型的数据---StringHttpMessageConverter
     *
     *  2. 框架调用StringHttpMessageConverter.write()方法，把String对象转为text/plain;charset=UTF-8，
     *
     *  3. 框架会调用@ResponseBody把结果数据输出到浏览器，ajax请求处理完成
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "doReturnString.do", produces = "text/plain;charset=UTF-8")
    public String doReturnString(){
        return "hello world! 你好世界";
    }
}
