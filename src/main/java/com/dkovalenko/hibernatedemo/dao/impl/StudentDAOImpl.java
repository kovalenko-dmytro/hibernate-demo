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
}
