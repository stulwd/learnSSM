package com.lwdHouse.service.impl;

import com.lwdHouse.dao.StudentDao;
import com.lwdHouse.domain.Student;
import com.lwdHouse.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudent();
        return students;
    }
}
