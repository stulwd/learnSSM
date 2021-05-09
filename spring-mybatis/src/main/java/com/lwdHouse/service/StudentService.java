package com.lwdHouse.service;

import com.lwdHouse.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> queryStudent();
}
