## 发起的请求是由哪些服务器程序处理的

### tomcat默认的servlet处理的
- http://localhost:8080/springMVC_02/html/test.html
- http://localhost:8080/springMVC_02/images/p1.jpg
- http://localhost:8080/springMVC_02/js/jquery.js
- http://localhost:8080/springMVC_02/index.html

### DispatcherServlet处理的
- http://localhost:8080/springMVC_02/some.do

### tomcat默认的servlet定义在哪里？
- tomcat安装目录/conf/web.xml里定义的default servlet用来处理所有静态资源

### tomcat默认的servlet作用
1. 处理静态资源
2. 处理未映射到其他servlet的请求

如果用户的servlet使用了/，如<url-pattern>/</url-pattern>, 则他会替代默认的default servlet, 即所有未处理的映射
都会交给这个servlet来处理

一般开发中，都将dispatcherservlet的<url-pattern>指定为/，
所以如果用户只定义了一个dispatcherservlet，且指定映射为<url-pattern>/</url-pattern>
那么除了jsp资源，所有的请求，包括静态请求，动态请求都由这个dispatcherservlet来处理，那么会造成静态资源无法处理的情况
（ps：为什么jsp资源可以访问？因为tomcat安装目录/conf/web.xml 中定义了能处理jsp的servlet），那么如何解决这种问题？

- 方法一：需要在springmvc配置文件加入 <mvc:default-servlet-handler> 这个处理器会把请求转发给
默认的servletHandler处理静态资源

- 方法二：需要在springmvc配置文件加入<mvc:resources/>

此后，我们的@RequestMapping的值就不需要加上特定的后缀，例如some.do, 而是直接使用some即可


--- 
## 绝对地址和相对地址


1. 如果开头有/，则/代表http://ip:port/, 没有工程名
2. 在jsp页面中，如果你的地址没有/开头，则访问地址是当前页面地址+链接地址
   
   这会导致一些问题，例如在本例中，index.jsp如果发送some请求，some会转发到show2界面下，由show2再请求index.jsp，请求链接为
   http://localhost:8080/springMVC_02/index.jsp，就没有问题
   但是index.jsp如果发送a/b/c/d/some2请求，a/b/c/d/some2也会转发到show2界面，但是此时网页地址依然为a/b/c/d/some2，再请求index.jsp
   请求链接就变为http://localhost:8080/springMVC_02/a/b/c/d/index.jsp
   
### 解决方案
    1. 加入${pageContext.request.contextPath}
    2. 加入一个base标签，表示当前页面的地址，参考show2.jsp。(加上之后，以斜杠开头的地址仍然会被解析为http://ip:port/)
    
    


