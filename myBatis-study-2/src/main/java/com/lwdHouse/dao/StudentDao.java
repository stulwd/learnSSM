package com.lwdHouse.dao;

import java.util.List;

import com.lwdHouse.domain.Student;

public interface StudentDao {
    public List<Student> selectStudents();
    public int insertStudent(Student student);
}