package com.lwdHouse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.lwdHouse.domain.Student;
import com.lwdHouse.utils.MybatisUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
//         自动提交打开，则不需要执行sqlSession.commit()进行手动提交
        // SqlSession sqlSession = factory.openSession(true);
        // 一般把上面的几行封装到mybatisUtils工具类里面，这里直接获取sqlSession即可
        // SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.lwdHouse.dao.StudentDao." + "selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach(stu -> System.out.println(stu));
        // sqlSession.close();

        sqlId = "com.lwdHouse.dao.StudentDao." + "insertStudent";
        // int res = sqlSession.insert(sqlId);\
        Student s1 = new Student();
        s1.setName("liuwendiaaa");
        s1.setId(666);
        s1.setAge(20);
        s1.setSex("male");
        int res = sqlSession.insert(sqlId, s1);
        System.out.println("执行insert结果："+ res);
        sqlSession.commit();
        //用完一定要关闭
        sqlSession.close();

        // sqlSession.selectOne(statement);
        // sqlSession.update(statement);
        // sqlSession.delete(statement);
        // sqlSession.rollback();
    }
}
