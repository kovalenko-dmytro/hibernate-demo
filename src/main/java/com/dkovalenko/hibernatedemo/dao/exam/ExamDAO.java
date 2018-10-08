package com.dkovalenko.hibernatedemo.dao.exam;

import com.dkovalenko.hibernatedemo.dao.AbstractDAO;
import com.dkovalenko.hibernatedemo.entity.exam.Exam;
import org.springframework.stereotype.Repository;

@Repository("examDAO")
public class ExamDAO extends AbstractDAO<Exam> {

    public ExamDAO(Exam exam) {
        super(exam);
    }

    @Override
    public Exam update(Exam exam) {

        Exam updatedExam = find(exam.getId());
        updatedExam.setStudent(exam.getStudent());
        updatedExam.setSubject(exam.getSubject());
        updatedExam.setGrade(exam.getGrade());

        entityManager.flush();

        return updatedExam;
    }
}
