package com.dkovalenko.hibernatedemo.service.exam;

import com.dkovalenko.hibernatedemo.dao.exam.ExamDAO;
import com.dkovalenko.hibernatedemo.entity.exam.Exam;
import com.dkovalenko.hibernatedemo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("examService")
public class ExamService extends AbstractService<Exam, ExamDAO> {

    @Autowired
    protected ExamService(ExamDAO repository) {
        super(repository);
    }
}
