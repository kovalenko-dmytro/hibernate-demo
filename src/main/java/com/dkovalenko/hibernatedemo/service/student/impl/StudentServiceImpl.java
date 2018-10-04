package com.dkovalenko.hibernatedemo.service.student.impl;

import com.dkovalenko.hibernatedemo.dao.student.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import com.dkovalenko.hibernatedemo.service.student.StudentService;
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

    @Override
    public Student find(long studentID) {
        return studentDAO.find(studentID);
    }

    @Override
    public Student update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public void delete(long studentID) {
        studentDAO.delete(studentID);
    }
}
