package com.lwdHouse;

import java.util.List;

import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.domain.Student;
import com.lwdHouse.utils.MybatisUtils;
import com.lwdHouse.vo.QueryParam;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMyBatis {
    @Test
    public void test01() {
        // 不用2中的方法
        // StudentDao dao = new StudentDaoImpl();
        // 使用动态代理获取dao
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao="+dao.getClass().getName()); // dao=com.sun.proxy.$Proxy7 代表jdk动态代理
        List<Student> studentList = dao.selectStudents();
        studentList.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void test02() {
        // 不用2中的方法
        // StudentDao dao = new StudentDaoImpl();
        // 使用动态代理的方法获取dao
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setName("adi");
        stu.setAge(24);
        stu.setId(140224232);
        stu.setSex("male");
        int num = dao.insertStudent(stu);
        System.out.println("添加对象的数量："+ num);
    }

    @Test
    public void test03() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        
        // Student stu = dao.selectStudentById(14024237);
        // System.out.println("student="+stu);

        // List<Student> stuList =  dao.selectMultiParam("liuwendi", 20);
        // stuList.forEach(s1 -> System.out.println("stu="+s1));

        // QueryParam qp = new QueryParam();
        // qp.setParamAge(20);
        // qp.setParamName("liuwendi");
        // List<Student> stuList =  dao.selectMultiObject(qp);
        // stuList.forEach(s1 -> System.out.println("stu="+s1));

        // Student stu = new Student();
        // stu.setName("liuwendi");
        // stu.setAge(20);
        // List<Student> stuList =  dao.selectMultiStudent(stu);
        // stuList.forEach(s1 -> System.out.println("stu="+s1));

        List<Student> stuList =  dao.selectMultiPosition("liuwendi", 20);
        stuList.forEach(s1 -> System.out.println("stu="+s1));
    }
}