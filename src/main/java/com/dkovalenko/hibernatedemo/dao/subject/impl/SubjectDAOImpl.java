package com.dkovalenko.hibernatedemo.dao.subject.impl;

import com.dkovalenko.hibernatedemo.dao.subject.SubjectDAO;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class SubjectDAOImpl implements SubjectDAO {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public Set<Subject> find() {

        return new HashSet<>((List<Subject>) entityManager.createQuery("SELECT s FROM Subject s").getResultList());
    }

    @Override
    public Subject find(long subjectID) {

        return entityManager.find(Subject.class, subjectID);
    }

    @Override
    public Subject save(Subject subject) {

        entityManager.persist(subject);

        return subject;
    }

    @Override
    public Subject update(Subject subject) {

        Subject updatedSubject = find(subject.getId());

        updatedSubject.setName(subject.getName());

        entityManager.flush();

        return updatedSubject;
    }

    @Override
    public void delete(long subjectID) {

        entityManager.remove(find(subjectID));
    }
}
