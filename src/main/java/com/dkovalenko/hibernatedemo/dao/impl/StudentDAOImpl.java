package com.dkovalenko.hibernatedemo.dao.impl;

import com.dkovalenko.hibernatedemo.dao.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.Student;
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
    public void save(Student student) {

        entityManager.persist(student);

    }

    @Override
    public Student find(long studentID) {

        return entityManager.find(Student.class, studentID);
    }

    @Override
    public void update(Student student, long studentID) {

        Student updatedStudent = find(studentID);

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setAge(student.getAge());

        entityManager.flush();

    }

    @Override
    public void delete(long studentID) {

        entityManager.remove(find(studentID));
    }
}
