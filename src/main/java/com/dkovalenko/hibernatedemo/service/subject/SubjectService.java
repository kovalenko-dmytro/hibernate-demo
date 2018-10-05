package com.dkovalenko.hibernatedemo.service.subject;

import com.dkovalenko.hibernatedemo.entity.subject.Subject;

import java.util.Set;

public interface SubjectService {

    Set<Subject> find();

    Subject save(Subject subject);

    Subject find(long subjectID);

    Subject update(Subject subject);

    void delete(long subjectID);
}
