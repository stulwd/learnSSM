package com.lwdHouse;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.dao.StudentDynamicDao;
import com.lwdHouse.domain.IdCard;
import com.lwdHouse.domain.Student;
import com.lwdHouse.utils.MybatisUtils;
import com.lwdHouse.vo.QueryParam;

import com.lwdHouse.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sql.DataSource;
import javax.swing.text.View;

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
        sqlSession.commit();
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

//        List<Student> stuList =  dao.selectMultiPosition("liuwendi", 20);
//        stuList.forEach(s1 -> System.out.println("stu="+s1));

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "liuwendi");
//        map.put("age", 20);
//        List<Student> studentList = dao.selectMultiByMap(map);

//        List<Student> studentList = dao.selectStudentsBy$("liuwendi");
        // sql注入（非法获取全部数据）
//        List<Student> studentList2 = dao.selectStudentsBy$("\"liuwendi\" or 1=1");

        PageHelper.startPage(3, 4);
        ColName col = new ColName();
        List<Student> studentList = dao.selectStudentByOrder(col.name);
    }

    @Test
    public void test04() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        ViewStudent stu = dao.selectStudentReturnViewStudent(14024299);
        System.out.println(stu);

        Integer total = dao.countStudent();
        System.out.println("student numbers:" + total);

        List< Map<Object, Object> > stuMap = dao.selectStudentReturnMap(666);
        stuMap.forEach(stumap -> System.out.println(stumap));

        List<Student> stuList = dao.selectAllStudents();
        stuList.forEach(stuEle -> System.out.println(stuEle));

        List<IdCard> IdCardList = dao.selectAllIdCards();
        IdCardList.forEach(idCard -> System.out.println(idCard));

        List<IdCard> IdCardList2 = dao.selectAllIdCards2();
        IdCardList2.forEach(idCard2 -> System.out.println(idCard2));

        List<Student> studentList2 = dao.slectLikeName("wendi");
        studentList2.forEach(stuEle -> System.out.println(stuEle));
    }

    @Test
    public void test05() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentDynamicDao dao = session.getMapper(StudentDynamicDao.class);

        List<Student> stuList = dao.selectQualifiedStudent(16, "adi");
        stuList.forEach(student -> System.out.println(student));

        List<Student> stuList2 = dao.selectQualifiedStudent2(19, "");
        stuList2.forEach(student -> System.out.println(student));
    }

    @Test
    public void test06() {
        SqlSession session = MybatisUtils.getSqlSession();
        StudentDynamicDao dao = session.getMapper(StudentDynamicDao.class);
        List<Integer> intList = new ArrayList<>();
        intList.add(14024237);
        intList.add(14024239);
        List<Student> stuList = dao.selectQualifiedStudent3(intList);
        stuList.forEach(student -> System.out.println(student));

        List<Student> objList = new ArrayList<>();
        objList.add(new Student("", 14024237, 0, ""));
        objList.add(new Student("", 14024239, 0, ""));
        List<Student> Stulist2 = dao.selectQualifiedStudent4(objList);
        Stulist2.forEach(student -> System.out.println(student));

    }
}

class ColName {
    public String id = "id";
    public String name = "name";
    public String age = "age";
    public String sex = "sex";
}