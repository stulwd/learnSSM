package com.lwdHouse;

import java.util.List;

import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.dao.impl.StudentDaoImpl;
import com.lwdHouse.domain.Student;

import org.junit.Test;

public class TestMyBatis {
    @Test
    public void test01() {
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        studentList.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void test02() {
        StudentDao dao = new StudentDaoImpl();
        Student stu = new Student();
        stu.setName("adi");
        stu.setAge(24);
        stu.setId(140224232);
        stu.setSex("male");
        int num = dao.insertStudent(stu);
        System.out.println("添加对象的数量："+ num);
    }
}