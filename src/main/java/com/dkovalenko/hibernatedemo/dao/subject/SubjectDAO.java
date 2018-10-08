package com.dkovalenko.hibernatedemo.dao.subject;

import com.dkovalenko.hibernatedemo.dao.AbstractDAO;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import org.springframework.stereotype.Repository;


@Repository("subjectDAO")
public class SubjectDAO extends AbstractDAO<Subject> {

    public SubjectDAO(Subject subject) {
        super(subject);
    }

    @Override
    public Subject update(Subject subject) {

        Subject updatedSubject = find(subject.getId());

        updatedSubject.setName(subject.getName());

        entityManager.flush();

        return updatedSubject;
    }
}
