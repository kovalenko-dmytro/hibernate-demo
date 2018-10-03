package com.dkovalenko.hibernatedemo.service.impl;

import com.dkovalenko.hibernatedemo.dao.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.Student;
import com.dkovalenko.hibernatedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> find() {
        return studentDAO.find();
    }

    @Override
    public Student save(Student student) {

        return studentDAO.save(student);
    }
}
