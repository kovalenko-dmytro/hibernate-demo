package com.dkovalenko.hibernatedemo.service.student.impl;

import com.dkovalenko.hibernatedemo.dao.student.impl.StudentDAOImpl;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import com.dkovalenko.hibernatedemo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("studentServiceImpl")
public class StudentServiceImpl extends AbstractService<Student, StudentDAOImpl> {

    @Autowired
    public StudentServiceImpl(@Qualifier("studentDAOImpl") StudentDAOImpl repository) {
        super(repository);
    }
}
