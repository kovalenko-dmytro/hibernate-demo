package com.dkovalenko.hibernatedemo.service.subject;

import com.dkovalenko.hibernatedemo.dao.subject.SubjectDAO;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import com.dkovalenko.hibernatedemo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends AbstractService<Subject, SubjectDAO> {

    @Autowired
    public SubjectService(SubjectDAO repository) {
        super(repository);
    }
}
