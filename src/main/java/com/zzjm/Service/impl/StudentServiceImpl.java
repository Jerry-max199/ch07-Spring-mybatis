package com.zzjm.Service.impl;

import com.zzjm.Service.StudentService;
import com.zzjm.dao.StudentDao;
import com.zzjm.domain.Student;

import java.util.List;


public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums=studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
       List<Student> list= studentDao.selectStudent();
        return list;
    }
}
