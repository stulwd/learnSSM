## 发起的请求是由哪些服务器程序处理的

tomcat默认的servlet处理的
- http://localhost:8080/springMVC_02/html/test.html
- http://localhost:8080/springMVC_02/images/p1.jpg
- http://localhost:8080/springMVC_02/js/jquery.js
- http://localhost:8080/springMVC_02/index.html

DispatcherServlet处理的
- http://localhost:8080/springMVC_02/some.do

tomcat默认的servlet定义在哪里？
- tomcat安装目录/conf/web.xml里定义的default servlet用来处理所有静态资源

tomcat默认的servlet作用
1. 处理静态资源
2. 处理未映射到其他servlet的请求

如果用户的servlet使用了/，如<url-pattern>/</url-pattern>, 则他会替代默认的default servlet, 即所有未处理的映射
都会交给这个servlet来处理

一般开发中，都将dispatcherservlet的<url-pattern>指定为/，
所以如果用户只定义了一个dispatcherservlet，且指定映射为<url-pattern>/</url-pattern>
那么除了jsp资源，所有的请求，包括静态请求，动态请求都由这个dispatcherservlet来处理，那么会造成静态资源无法处理的情况
（ps：为什么jsp资源可以访问？因为tomcat安装目录/conf/web.xml 中定义了能处理jsp的servlet），那么如何解决这种问题？

方法一：需要在springmvc配置文件加入 <mvc:default-servlet-handler> 这个处理器会把请求转发给
默认的servletHandler处理静态资源

方法二：需要在springmvc配置文件加入<mvc:resources/>

此后，我们的@RequestMapping的值就不需要加为特定的后缀，例如some.do, 而是直接使用some即可



