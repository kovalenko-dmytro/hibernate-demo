package com.dkovalenko.hibernatedemo.service.student;

import com.dkovalenko.hibernatedemo.dao.student.StudentDAO;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import com.dkovalenko.hibernatedemo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService extends AbstractService<Student, StudentDAO> {

    @Autowired
    public StudentService(StudentDAO repository) {
        super(repository);
    }
}
