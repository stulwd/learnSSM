# spring
1. spring-ioc01

初识spring

--- 
2. spring-di-xml xml式依赖注入
- ba01
    - `<bean>`标签
    - `<property...>`属性set注入
    - 创建jar包中的bean
- ba02
    - 对象注入：`<property ... ref="mySchool"/>`
- ba03
    - 构造注入constructor-arg
      - value: `<constructor-arg name="name" value="张三"/>`
      - ref: `<constructor-arg name="school" ref="mySchool"/>`
      - index指定参数顺序: `<constructor-arg index="0" value="张三"/>`
      - 使用默认顺序: `<constructor-arg value="张三"/>`
- ba04
    - 按名称自动注入autowire`<bean id="myStudent" class="com.bjpowernode.ba04.Student" autowire="byName">`
- ba05
    - 按类型自动注入`<bean id="myStudent" class="com.bjpowernode.ba05.Student" autowire="byType">`
- ba06
    - 导入其他的beans.xml`<import resource="classpath:ba06/spring-*.xml" />`
    
---
3. spring-di-annotation 注解式依赖输入
- @Component("xxx")
- @Value("xxx")
- @Autowired的byName和byType自动注入
- @Resource的byName和byType自动注入
- 声明组建扫描器
- 指定属性配置文件路径
---
4. spring-ioc-homework
- spring的xml方式开发小作业
---
5. spring-aop 面向切面编程
- jdk动态代理实现：MyTest.java MyInvocationHandler.java
- 基于aspectj的aop实现
    - 依赖项：spring-context，spring-aspects
    - 通过配置织入@Aspectj切面:`<aop:aspectj-autoproxy>`
    - @Aspect注解
    - 五种通知的执行顺序
    - 切入点表达式 execution
    - joinPoint
        - getSignature
        - getArgs
    - 五种通知
        - @Before
        - @AfterReturning
            - returning
        - @Around
            - ProceedingJoinPoint
                - getArgs()
                - proceed()调用业务方法
        - @AfterThrowing
            - throwing
        - @After
    - 切入点@Pointcut
---
6. reflact-study反射
- 获取类对象方法
    - `对象.getClass()`
    - `类名.class`
    - `Class.forName("类路径")`
- 获取构造器
    - 全部构造器:`class1.getConstructors();`
    - 某个构造器:`class1.getConstructor(String.class, Integer.class)`
    - 使用构造器创建对象: `newInstance()`
- 获取方法
    - `getMethods()`
    - `getDeclaredMethods()`
    - `getMethod("方法名", 参数类对象)`
    - `getDeclaredMethod("方法名", 参数类对象)`
    - `setAccessible()`设置方法访问权限
    - 调用`invoke()`
- 编写一个能调用任何方法的方法
- 获取字段
    - `getDeclaredFields()`
    - `getDeclaredField("字段名")`
    - `setAccessible()`设置字段访问权限
    - `set(对象，值)`
    - `get(对象)`
---
7. designMode
- com.lwdHouse.designMode.myEnum 枚举类型
- 工厂模式 com.lwdHouse.designMode.factory/service/service.impl app 使用反射实现开闭原则:对修改关闭，对新增开放
- 单例模式 com.lwdHouse.designMode.singleton
    - 饿汉式单例 SingletonEHan
        - 浪费空间
        - 构造方法私有化
    - 懒汉式单例 
        - SingletonLanHan
            - 线程不安全版本
            - 使用synchronized实现线程安全的改进版本 
            - 最佳版本
        - SingletonLanHan2
            - 静态内部类实现
            - 线程安全
            - 不浪费空间
        - 创建多线程测试单例模式 (AppTest.java:单例模式测试)
- 注解
    - @Target
    - @Retention
    - 自定义注解
    - 注解的属性类型
    - 用反射获取注解信息 (AppTest.java:用反射获取注解)
    
---
8. spring-mybatis: spring整合mybatis
- 依赖
    - spring-context
    - mybatis
    - mybatis-spring
    - mysql-connector-java
    - druid
    - spring-tx
    - spring-jdbc
- spring配置文件内容
    - 德鲁伊数据源bean DruidDataSource
        - init-method
        - destroy-method
    - sqlSessionFactory bean
    - MapperScannerConfigurer bean
    - Service bean (可以通过注解创建)
- mybatis配置文件内容
    - 设置mybatis输出日志
    - typeAliases包的别名
    - 指定mappers路径
- dao接口
- dao.xml文件
    - mapper总标签的namespace属性
    - select标签
    - insert标签

---
9. spring-mybatis-trans 事务功能
- 依赖
    - spring-context
    - mybatis
    - mybatis-spring
    - mysql-connector-java
    - druid
    - spring-tx
    - spring-jdbc
    - spring-aspects
- 事务处理方式一
    - spring配置文件
        - 创建DataSourceTransactionManager bean`<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">`
            - 设置属性 `<property name="dataSource" ref="xxx"/>`
        - 开启事务注解驱动
            - `<tx:annotation-driven transaction-manager="transactionManager"/>`
    - 业务方法上
        -  使用 @Transactional
            - 传播类型 propagation
            - 隔离级别 isolation
            - readOnly
            - 要回滚的异常 rollbackFor
- 事务处理方式二 (比方式一更加精细)
    - spring配置文件
      - 创建DataSourceTransactionManager bean`<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">`
            - 设置属性 `<property name="dataSource" ref="xxx"/>`
      - 开启事务通知
        ```xml
                
        <tx:advice id="myAdvice" transaction-manager="transactionManager">
                <tx:attributes>
                <!--name: 方法名称，1）完整的方法名称，不带有包和类名
                                  2）方法可以使用通配符,* 表示任意字符
                    propagation: 传播行为，枚举值
                    isolation: 隔离级别
                    rollback-for: 需要回滚的异常类名-->
                <tx:method name="buy" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.NullPointerException;com.lwdHouse.excep.NotEnoughException" />
                <tx:method name="add*" propagation="REQUIRES_NEW"/>
                <tx:method name="modify*" />
                <tx:method name="remove*"/>
                <tx:method name="*" propagation="SUPPORTS" read-only="true"/>
                </tx:attributes>
        </tx:advice>
        ```
      - 配置aop
        ```xml
        <aop:config>
                <aop:pointcut id="servicePt" expression="execution(* *..service..*.*(..))"/>
                <aop:advisor advice-ref="myAdvice" pointcut-ref="servicePt"/>
        </aop:config>
        ```
        
---
10. spring-web
- web.xml配置文件
    - servlet
        - servlet-name
        - servlet-class
    - servlet-mapping
        - servlet-name
        - url-pattern
    - 注册监听器ContextLoaderListener, 创建wac到sc中
    - 设置contextConfigLocation属性，指定spring配置文件路径
- servlet类
    - doPost和doGet
        - 获取sc: getServletContext()
        - 获取wac: `WebApplicationContextUtils.getRequiredWebApplicationContext(sc)`
        - 获取bean: `wac.getBean("xxx")`
        - HttpServletRequest参数
            - getParameter()方法
            - getRequestDispatcher("xxx").forward(req, resp)请求转发
   
--- 
# mybatis
1. myBatis-study
- mybatis.xml mybatis配置文件
    - settings标签 控制mybatis全局行为
    - environments标签 全部环境
        - environment标签 定义环境
            - transactionManager标签 指定事务管理器
            - dataSource标签 指定数据源
                - driver : com.mysql.jdbc.Driver
                - url
                - username
                - password
    - mappers标签，指定各个mapper.xml路径

- 获取sqlSession的步骤
    
  ```java
      InputStream in = Resources.getResourceAsStream("mybatis配置文件");
      SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
      SqlSessionFactory factory = builder.build(in);
      SqlSession sqlSession = factory.openSession();
      //SqlSession sqlSession = factory.openSession(true); // 自动提交事务 
  ```
   
- sqlSession的方法
    - sqlSession.selectList("com.lwdHouse.dao.StudentDao.selectStudents") sqlId定义在了dao.xml文件里
    - sqlSession.insert(sqlId, 对象)
    - sqlSession.commit(); // 提交事务
    - sqlSession.close();  // 用完关闭
    - sqlSession.selectOne()
    - sqlSession.update()
    - sqlSession.delete()
    - sqlSession.rollback()
    
- 传统jdbc用法：参考test.java.com.lwdHouse.AppTest

---
2. myBatis-study-2
- 创建MybatisUtils类，维护一个公共的SqlSessionFactory, 获取sqlSession()
- 创建dao.impl, 实现每一个接口的方法，方法内调用MybatisUtils.getSession()获取session，做相应的数据库操作

---
3. myBatis-study-3-proxy
- mybatis.xml配置文件
    - 导入属性配置文件`<properties resource="jdbc.properties"/>`
    - settings标签 控制mybatis全局行为
    - typeAliases用法
        - 一一指定：`<typeAlias type="com.lwdHouse.domain.Student" alias="stu"/>`
        - 指定包名：`<package name="com.lwdHouse.domain"/>`
            - 缺点：如果指定多个package，某两个package下存在同名类，会报错
    - 分页技术
        - 定义com.github.pagehelper.PageInterceptor plugin
    - mappers标签用法
        - 指定资源名 `<mapper resource="com/lwdHouse/dao/StudentDao.xml"/>`
        - 指定包名 `<package name="com.lwdHouse.dao"/>`
- dao.xml文件
    - 传参
        - 简单类型: parameterType属性的使用
        - 对象类型: `public int insertStudent(Student student);`  =>  `insert into student values(#{name}, #{id}, #{age}, #{sex})`
        - 多个参数: @Param参数注解
        - 位置传参: `name=#{arg0} and age=#{arg1}`
        - map传参: 不推荐
        - $和#区别: $不安全，但是有时候必须要用$,如`select * from student order by ${colum}`
    - 返回值
        - 使用resultType指定
        - 使用resultMap指定映射关系
    - 模糊匹配
    - 动他sql
        - if标签
        - where标签
        - foreach标签
        - sql标签
        - 使用include标签引用sql标签内容
    
# springMVC
1. tomcat-study tomcat基础
- HelloServlet2
    - 继承servlet类
        - init方法
        - destroy方法
        - servletConfig对象
            - getServletName()
            - getInitParameter()
            - getServletContext()
        - service方法
            - servletRequest强转为HttpServletRequest
            - 获取请求方法：httpServletRequest.getMethod()
    
- HelloServlet3
    - 继承HttpServlet类
        - 带参数init方法和无参数init方法区别
        - doGet()和doPost()
            - getServletConfig()
            - getServletName()
            - getInitParameter()
            - getServletContext()
    
- HelloServlet4
    - web路径和工程实际路径的映射关系
    - getServletContext()
    - ServletContext的作用
        - getInitParameter()
        - getContextPath()
        - getRealPath()
        - getAttribute()
        - setAttribute()
    
- annotationServlet
    - 使用注解而不是web.xml创建sevlet
    - @WebServlet(name = "annotationServlet", value = "/hello5")
    
- HelloServlet6
    - 无参init方法
    - doGet()
        - getServletContext()
        - HttpServletRequest用法
            - getRequestURI()
            - getRequestURL()
            - getRemoteHost()
            - getHeader("key")
            - getMethod()
            - getParameter()
            - getParameterValues() 获取list类型参数
            - 设置请求编码setCharacterEncoding("UTF-8")
    
- 请求转发(Forward1 Forward2 Forward3)
    - getRequestDispatcher("资源路径").forward()
    - 请求转发的特点
        - 浏览器的地址没有变化
        - 他们是一次请求
        - 他们共享request域中的数据
        - 可以转发到WEB-INF目录下
        - 不能访问工程以外的资源
    
- 请求重定向(redirectServlet1 redirectServlet2)
    - 设置请求重定向的两种方法：
        - response.setStatus(302); response.setHeader("Location", "http://localhost:8088/helloWeb/redirectServlet2");
        - response.sendRedirect("http://localhost:8088/helloWeb/redirectServlet2");
    - 请求重定向特点
        - 可以访问域外资源
        - 不能访问受保护目录，会返回404
        - 两次请求
        - 浏览器的地址会发生变化
        - 不共享Request域中的数据
    
- respServlet
    - 设置响应编码 
        - response.setCharacterEncoding("UTF-8");
        - 或者 response.setHeader("Content-Type", "text/html; charset=UTF-8");
        - 或者 response.setContentType("text/html; charset=UTF-8");
    - 写响应数据: 
        - PrintWriter pw = response.getWriter(); pw.write("response's contect!!!");
        - 不能既使用getwriter()又使用getOutputStream()方法，会报错
    - response.getCharacterEncoding()

- web.xml
    - `<context-param>`标签
    - `<init-param>`标签
    
- base标签的作用
    - 参考index2.html Forward3.java /a/b/c.html
    
- /被浏览器和服务器解析的路径区别
    - 参考index2.html
    
---
2. springMVC-01
- 创建DispatcherServlet
    - 在web.xml中声明DispatcherServlet
    - 通过<init-param>标签设置spring.xml配置文件路径 contextConfigLocation
    - 启动tomcat即创建servlet 使用load-on-startup标签配置
- 配置视图解析器
    - 在spring配置文件中创建InternalResourceViewResolver bean，设置前后缀属性
- 配置组建扫描器
    - 在spring配置文件中添加 context:component-scan 组建扫描器，扫描controller下所有组建
- MyController
    - @Controller
    - @RequestMapping(value = {"", ""})
        - 放在方法上
    - ModelAndView
        - mv.addObject("", "")
        - mv.setViewName("")

- MyController2 设置公共的访问路径
    - @RequestMapping
        - 放在controller类上

- MyController3 请求的method
    - @RequestMapping指定method
    
- MyController4 请求参数
    - 使用HttpServletRequest来接受
    - 用参数名作为形参名来接受参数
        - 在web.xml中声明过滤器来设置字符编码
    - 使用@RequestParam注解来修正参数名和形参名不一致
    - 对象接受参数: 调用对象的set方法
    
- MyController5 返回类型
    - 处理器方法返回string 表示视图名称
    - 处理器方法返回void，响应ajax请求
        - 调用service处理业务逻辑
        - 转成json字符串
        - 写response
            - 调用setContentType设置类型为application/json;charset=utf-8