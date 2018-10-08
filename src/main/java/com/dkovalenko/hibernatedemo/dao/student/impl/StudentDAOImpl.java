package com.dkovalenko.hibernatedemo.dao.student.impl;

import com.dkovalenko.hibernatedemo.dao.AbstractDAO;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("studentDAOImpl")
public class StudentDAOImpl extends AbstractDAO<Student> {

    @Autowired
    public StudentDAOImpl(@Qualifier("student") Student student) {
        super(student);
    }

    @Override
    public Student update(Student student) {

        Student updatedStudent = find(student.getId());

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAge(student.getAge());

        entityManager.flush();

        return updatedStudent;

    }

}
