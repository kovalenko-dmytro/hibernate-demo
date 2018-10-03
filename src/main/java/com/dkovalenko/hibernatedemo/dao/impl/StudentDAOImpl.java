package com.dkovalenko.hibernatedemo.dao.impl;

import com.dkovalenko.hibernatedemo.dao.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    @Override
    public List<Student> find() {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }
}
