package com.lwdHouse.dao;

import com.lwdHouse.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student stu);
    List<Student> selectStudent();
}
