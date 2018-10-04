package com.dkovalenko.hibernatedemo.dao;

import com.dkovalenko.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> find();

    Student save(Student student);

    Student find(long studentID);

    Student update(Student student);

    void delete(long studentID);
}
