package com.dkovalenko.hibernatedemo.controller.exam;

import com.dkovalenko.hibernatedemo.controller.AbstractController;
import com.dkovalenko.hibernatedemo.entity.exam.Exam;
import com.dkovalenko.hibernatedemo.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller("examController")
public class ExamController extends AbstractController<Exam, ExamService> {

    @Autowired
    public ExamController(@Qualifier("examService") ExamService service) {
        super(service);
    }

    @Override
    public ModelAndView find() {
        return null;
    }

    @Override
    public ModelAndView find(long id) {
        return null;
    }

    @Override
    public ModelAndView create() {
        return null;
    }

    @Override
    public ModelAndView create(Exam exam) {
        return null;
    }

    @Override
    public ModelAndView update(long id) {
        return null;
    }

    @Override
    public ModelAndView update(long id, Exam exam) {
        return null;
    }

    @Override
    public ModelAndView delete(long id) {
        return null;
    }
}
