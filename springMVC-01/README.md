# SpringMVC
springMVC就是一个spring。
```
我们要做的就是使用`@Controller`注解创建控制器对象，
把对象放入到springMVC容器中，把创建的对象作为控制器使用，
这个控制器对象能够接受用户的请求，显示处理结果，就当作是一个servlet使用。
```
使用`@Controller`注解创建的对象是一个普通类的对象，不是servlet。
springMVC赋予了控制器对象一些额外的功能。

web开发的底层是servlet，springMVC中有一个对象是servlet: **DispacherServlet**

DispacherServlet作用是: 负责接受用户的所有请求，用户把请求给
DispatcherServlet，之后DispatcherServlet把请求转发给我们的
`controller`对象

## Spring框架的优点
- 基于MVC框架，分工明确，解耦合
- 作为spring的一部分，能够使用spring的IOC和AOP，方便整合`strtus, Mybatis
Hibernate,JPA`其他的框架
- 使用`@Controller`创建处理器，`@Service`创建业务对象，`@Autowired` 
  `@Resource`在控制器类中注入Service，Service类中注入Dao
  
## 实现步骤
- 新建web maven工程
- 加入依赖
  - spring-mvc依赖，间接把spring依赖全部加入
  - jsp, servlet依赖
  

## SpringMVC的MVC组件
```
  request     -------------    request     ------------- 
===========> |   Front     | ===========> |    back     |
<=========== | controller  | <==Model==== | controller  |  M (mv.addObject("k", "v"))
  response    -------------                ------------- 
                /\     ||
               /||\   Model
                ||    \||/
                ||     \/
              -------------           
             |     view    |    V (mv.setViewName("show"))    
              -------------           

```