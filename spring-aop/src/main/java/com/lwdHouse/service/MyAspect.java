package com.lwdHouse.service;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /**
     * 所有通知的执行顺序
     * @param jp
     */
    // try{
    //     try{
    //         doBefore();//对应@Before注解的方法切面逻辑
    //         method.invoke();
    //     }finally{
    //         doAfter();//对应@After注解的方法切面逻辑
    //     }
    //     doAfterReturning();//对应@AfterReturning注解的方法切面逻辑
    // }catch(Exception e){
    //      doAfterThrowing();//对应@AfterThrowing注解的方法切面逻辑
    // }


    // @Before(value = "execution(public void com.lwdHouse.service.SomeServiceImpl.doSome(String, Integer))")
    // @Before(value = "execution(void *..lwdHouse.service.SomeServiceImpl.doSome(String, Integer))")   // 可以省略权限标识
    // @Before(value = "execution(* *..lwdHouse.service.SomeServiceImpl.doSome(String, Integer))")
    // @Before(value = "execution(* *..lwdHouse.service.SomeServiceImpl.doSome(..))")
    // @Before(value = "execution(* *..lwdHouse.service.SomeServiceImpl.doSome(*, Integer))")
    // @Before(value = "execution(* *..lwdHouse.service.SomeServiceImpl.do*(*, Integer))")
    // @Before(value = "execution(* *..lwdHouse.service.SomeServiceImpl.do*(*, Integer))")
    // @Before(value = "execution(* do*(*, Integer))")
    @Before(value = "execution(* com.lwdHouse.service.*ServiceImpl.*(..))")
    public static void doLog(JoinPoint jp) {
        System.out.println("joinPoint.getSignature(): "+jp.getSignature());
        System.out.println("joinPoint.getSignature().getName(): "+jp.getSignature().getName());
        Object[] args = jp.getArgs();
        int index = 1;
        for (Object arg : args) {
            System.out.println("参数"+index+": "+arg);
            index++;
        }
        System.out.println("非业务方法，方法执行时间："+new Date());
    }

    @AfterReturning(value = "execution(String doOther(..))", 
                    returning = "res")
    public static void myAfterReturning(Object res) {
        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是"+res);
        if (res.equals("abcd")) {
            System.out.println("返回的结果正确");
        } else {
            System.out.println("返回的结果错误");
        }

        if (res != null) {
            res = "hello world!";
        }
    }

    @AfterReturning(value = "execution(Student *(..))",
                    returning = "res")
    public static void myAfterReturning2(JoinPoint jp, Object res) {
        System.out.println("后置通知2：在目标方法之后执行的，获取的返回值是"+res);
        Student stu = (Student) res;    // 向下转型
        stu.setAge(stu.getAge()+1);
    }

    // 最强大的环绕通知
    @Around(value = "execution(String *..doFirst(..))")
    public static Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        System.out.println("在目标方法之前，输出时间" + new Date());
        Object[] args = pjp.getArgs();
        Integer name = (Integer) args[1];
        // 成年后才能执行此方法
        if (name >= 18) {
            // 目标方法调用，环绕通知会包裹住其他的通知
            result = pjp.proceed();
        }
        System.out.println("在目标方法之后，提交事务");
        return result;
    }

    /**
     * 异常通知相当于：
     * 
     *       try {
     *           SomeService.doSecond()
     *       } catch (Exception e) {
     *           myAfterThrowing(e);
     *           throw e;
     *       }
     * @param ex
     */
    @AfterThrowing(value = "mypt()",
                    throwing = "ex")
    public static void myAfterThrowing(Exception ex) {
        System.out.println("异常通知：方法发生了异常，执行：" + ex.getMessage());
        // 发送邮件，短信，通知开发人员
    }
    
    /**
     * 最终通知，貌似和老师讲的不一样，因为这个@After总是先于@AfterThrwoing执行
     */
    @After(value = "mypt()")
    public static void doTrans() {
        System.out.println("执行最终通知，总是会被执行的代码");
        // 一般做资源清除工作
    }

    /**
     * 定义一个poincut
     */
    @Pointcut(value = "execution(void doSecond(..))")
    public void mypt() {
        // 无需代码
    }
}

