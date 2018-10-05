package com.dkovalenko.hibernatedemo.controller.subject;

import com.dkovalenko.hibernatedemo.entity.subject.Subject;
import com.dkovalenko.hibernatedemo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/subjects")
    public ModelAndView find() {

        ModelAndView view = new ModelAndView();
        view.addObject("subjects", subjectService.find());
        view.setViewName("subjects");

        return view;
    }

    @GetMapping(value = "/subjects/{subjectID}")
    public ModelAndView find(@PathVariable(value = "subjectID") long subjectID) {

        ModelAndView view = new ModelAndView();

        Subject subject = subjectService.find(subjectID);

        view.addObject("subject", subject);

        view.setViewName("subject-view");

        return view;
    }

    @GetMapping(value = "/subjects/create")
    public ModelAndView create() {

        ModelAndView view = new ModelAndView();
        view.addObject("subject", new Subject());
        view.setViewName("subject-create");

        return view;
    }

    @PostMapping(value = "/subjects")
    public ModelAndView create(@ModelAttribute Subject subject) {

        ModelAndView view = new ModelAndView();

        subjectService.save(subject);

        view.setViewName("redirect:/subjects");

        return view;
    }

    @GetMapping(value = "/subjects/{subjectID}/update")
    public ModelAndView update(@PathVariable(value = "subjectID") long subjectID) {

        ModelAndView view = new ModelAndView();
        view.addObject("subject", subjectService.find(subjectID));
        view.setViewName("subject-update");

        return view;
    }

    @PostMapping(value = "/subjects/{subjectID}")
    public ModelAndView update(@ModelAttribute Subject subject,
                               @PathVariable(value = "subjectID") long subjectID) {

        ModelAndView view = new ModelAndView();

        subject.setSubjectID(subjectID);
        subjectService.update(subject);

        view.setViewName("redirect:/subjects");

        return view;
    }

    @GetMapping(value = "/subjects/{subjectID}/delete")
    public ModelAndView delete(@PathVariable(value = "subjectID") long subjectID) {

        ModelAndView view = new ModelAndView();

        subjectService.delete(subjectID);

        view.setViewName("redirect:/subjects");

        return view;
    }
}
