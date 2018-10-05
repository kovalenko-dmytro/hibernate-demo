package com.dkovalenko.hibernatedemo.dao.subject;

import com.dkovalenko.hibernatedemo.entity.subject.Subject;

import java.util.Set;

public interface SubjectDAO {

    Set<Subject> find();

    Subject find(long subjectID);

    Subject save(Subject subject);

    Subject update(Subject subject);

    void delete(long subjectID);
}
