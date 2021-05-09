package com.lwdHouse.dao;

import com.lwdHouse.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDynamicDao {
    public List<Student> selectQualifiedStudent(@Param("age") int age,
                                                @Param("name") String name);

    public List<Student> selectQualifiedStudent2(@Param("age") int age,
                                                 @Param("name") String name);
    public List<Student> selectQualifiedStudent3(List<Integer> list);

    public List<Student> selectQualifiedStudent4(List<Student> stuList);
}
