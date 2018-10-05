package com.dkovalenko.hibernatedemo.service.subject.impl;

import com.dkovalenko.hibernatedemo.dao.subject.SubjectDAO;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import com.dkovalenko.hibernatedemo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectDAO subjectDAO;

    @Autowired
    public SubjectServiceImpl(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    @Override
    public Set<Subject> find() {
        return subjectDAO.find();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectDAO.save(subject);
    }

    @Override
    public Subject find(long subjectID) {
        return subjectDAO.find(subjectID);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectDAO.update(subject);
    }

    @Override
    public void delete(long subjectID) {
        subjectDAO.delete(subjectID);
    }
}
