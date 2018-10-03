package com.dkovalenko.hibernatedemo.service;

import com.dkovalenko.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> find();

    void save(Student student);

    Student find(long studentID);

    void update(Student student, long studentID);

    void delete(long studentID);
}
