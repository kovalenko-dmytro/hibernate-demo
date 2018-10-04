package com.dkovalenko.hibernatedemo.dao.student.impl;

import com.dkovalenko.hibernatedemo.dao.student.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> find() {

        return (List<Student>) entityManager.createQuery("SELECT s FROM Student s").getResultList();
    }

    @Override
    public Student save(Student student) {

        entityManager.persist(student);

        return student;

    }

    @Override
    public Student find(long studentID) {

        return entityManager.find(Student.class, studentID);
    }

    @Override
    public Student update(Student student) {

        Student updatedStudent = find(student.getStudentID());

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAge(student.getAge());

        entityManager.flush();

        return updatedStudent;

    }

    @Override
    public void delete(long studentID) {

        entityManager.remove(find(studentID));
    }
}
