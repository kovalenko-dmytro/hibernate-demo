package com.dkovalenko.hibernatedemo.dao;

import com.dkovalenko.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> find();

    void save(Student student);

    Student find(long studentID);

    void update(Student student, long studentID);

    void delete(long studentID);
}
