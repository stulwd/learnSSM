package com.lwdHouse.dao;

import java.util.List;

import com.lwdHouse.domain.Student;
import com.lwdHouse.vo.QueryParam;

import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student student);
    public Student selectStudentById(int id);
    public List<Student> selectMultiParam(@Param("myname") String name, 
                                          @Param("myage") Integer age);
    public List<Student> selectMultiObject(QueryParam param);
    public List<Student> selectMultiStudent(Student student);
    public List<Student> selectMultiPosition(String name, Integer age);
}