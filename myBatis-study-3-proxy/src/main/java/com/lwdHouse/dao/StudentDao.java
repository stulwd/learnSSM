package com.lwdHouse.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lwdHouse.domain.IdCard;
import com.lwdHouse.domain.Student;
import com.lwdHouse.vo.QueryParam;

import com.lwdHouse.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student student);
    public Student selectStudentById(int id);
    // 推荐
    public List<Student> selectMultiParam(@Param("myname") String name, 
                                          @Param("myage") Integer age);
    // 推荐
    public List<Student> selectMultiObject(QueryParam param);
    public List<Student> selectMultiStudent(Student student);
    public List<Student> selectMultiPosition(String name, Integer age);
    // 不推荐
    public List<Student> selectMultiByMap(Map<String, Object> stu);
    // $与#区别
    public List<Student> selectStudentsBy$(@Param("alias") String alias);

    public List<Student> selectStudentByOrder(@Param("colum") String col);

    public ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    public List<Map<Object, Object>> selectStudentReturnMap(@Param("sid") Integer id);

    public List<Student> selectAllStudents();

    public List<IdCard> selectAllIdCards();

    public List<IdCard> selectAllIdCards2();

    public List<Student> slectLikeName(@Param("name") String name);
}