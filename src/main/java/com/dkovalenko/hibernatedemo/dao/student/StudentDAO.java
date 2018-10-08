package com.dkovalenko.hibernatedemo.dao.student;

import com.dkovalenko.hibernatedemo.dao.AbstractDAO;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO extends AbstractDAO<Student> {

    public StudentDAO(Student student) {
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
