package com.dkovalenko.hibernatedemo.dao.student;

import com.dkovalenko.hibernatedemo.entity.student.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> find();

    Student save(Student student);

    Student find(long studentID);

    Student update(Student student);

    void delete(long studentID);
}
