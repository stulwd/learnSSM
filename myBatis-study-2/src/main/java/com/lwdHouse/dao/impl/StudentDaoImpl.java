package com.lwdHouse.dao.impl;

import java.util.List;

import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.domain.Student;
import com.lwdHouse.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int insertStudent(Student student) {
        // TODO Auto-generated method stub
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.lwdHouse.dao.StudentDao." + "insertStudent";
        int nums = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return nums;
    }

    @Override
    public List<Student> selectStudents() {
        // TODO Auto-generated method stub
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.lwdHouse.dao.StudentDao." + "selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
        return students;
    }
    
}