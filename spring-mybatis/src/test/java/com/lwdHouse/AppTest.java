package com.lwdHouse;

import static org.junit.Assert.assertTrue;

import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.domain.Student;
import com.lwdHouse.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器对象:"+ name + " | " + ctx.getBean(name));
        }
    }

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService)ctx.getBean("studentService");
        List<Student> stuList = studentService.queryStudent();
        stuList.forEach(stu -> System.out.println("stu: "+ stu));
    }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService)ctx.getBean("studentService");
        Student newStu = new Student();
        newStu.setAge(10);
        newStu.setId(14);
        newStu.setEmail("stulwd@163.com");
        newStu.setName("adi");
        // spring和mybatis整和在一起，事务自动提交。无需sqlSession.commit()
        int res = studentService.addStudent(newStu);
        System.out.println(res);
    }
}
