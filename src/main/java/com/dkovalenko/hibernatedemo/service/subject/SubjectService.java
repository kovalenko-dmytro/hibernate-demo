package com.dkovalenko.hibernatedemo.service.subject;

import com.dkovalenko.hibernatedemo.dao.subject.SubjectDAO;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import com.dkovalenko.hibernatedemo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("subjectService")
public class SubjectService extends AbstractService<Subject, SubjectDAO> {

    @Autowired
    public SubjectService(@Qualifier("subjectDAO") SubjectDAO repository) {
        super(repository);
    }
}
