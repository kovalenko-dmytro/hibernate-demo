package com.dkovalenko.hibernatedemo.entity.exam;

import com.dkovalenko.hibernatedemo.entity.AbstractEntity;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "exams")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exam extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int grade;
}
