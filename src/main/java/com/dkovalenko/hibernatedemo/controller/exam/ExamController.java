package com.dkovalenko.hibernatedemo.controller.exam;

import com.dkovalenko.hibernatedemo.controller.AbstractController;
import com.dkovalenko.hibernatedemo.entity.exam.Exam;
import com.dkovalenko.hibernatedemo.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController extends AbstractController<Exam, ExamService> {

    @Autowired
    public ExamController(ExamService service) {
        super(service);
    }

    @GetMapping(value = "/exams")
    public ModelAndView find() {

        ModelAndView view = new ModelAndView();
        view.addObject("exams", service.find());
        view.setViewName("exams");

        return view;
    }

    @GetMapping(value = "/exams/{examID}")
    public ModelAndView find(@PathVariable(value = "examID") long examID) {

        ModelAndView view = new ModelAndView();

        Exam exam = service.find(examID);

        view.addObject("exam", exam);

        view.setViewName("exam-view");

        return view;
    }

    @GetMapping(value = "/exams/create")
    public ModelAndView create() {

        ModelAndView view = new ModelAndView();
        view.addObject("exam", new Exam());
        view.setViewName("exam-create");

        return view;
    }

    @PostMapping(value = "/exams")
    public ModelAndView create(@ModelAttribute Exam exam) {

        ModelAndView view = new ModelAndView();

        service.save(exam);

        view.setViewName("redirect:/exams");

        return view;
    }

    @GetMapping(value = "/exams/{examID}/update")
    public ModelAndView update(@PathVariable(value = "examID") long examID) {

        ModelAndView view = new ModelAndView();
        view.addObject("exam", service.find(examID));
        view.setViewName("exam-update");

        return view;
    }

    @PostMapping(value = "/exams/{examID}")
    public ModelAndView update(@PathVariable(value = "examID") long examID,
                               @ModelAttribute Exam exam) {

        ModelAndView view = new ModelAndView();

        exam.setId(examID);
        service.update(exam);

        view.setViewName("redirect:/exams");

        return view;
    }

    @GetMapping(value = "/exams/{examID}/delete")
    public ModelAndView delete(@PathVariable(value = "examID") long examID) {

        ModelAndView view = new ModelAndView();

        service.delete(examID);

        view.setViewName("redirect:/exams");

        return view;
    }
}
