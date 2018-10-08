package com.dkovalenko.hibernatedemo.controller.student;

import com.dkovalenko.hibernatedemo.controller.AbstractController;
import com.dkovalenko.hibernatedemo.entity.student.Student;
import com.dkovalenko.hibernatedemo.service.student.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Component("studentController")
public class StudentController extends AbstractController<Student, StudentServiceImpl> {

    @Autowired
    public StudentController(@Qualifier("studentServiceImpl") StudentServiceImpl service) {
        super(service);
    }

    @GetMapping(value = "/students")
    public ModelAndView find() {

        ModelAndView view = new ModelAndView();
        view.addObject("students", service.find());
        view.setViewName("students");

        return view;
    }

    @GetMapping(value = "/students/{studentID}")
    public ModelAndView find(@PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();

        Student student = service.find(studentID);

        view.addObject("student", student);

        view.setViewName("student-view");

        return view;
    }

    @GetMapping(value = "/students/create")
    public ModelAndView create() {

        ModelAndView view = new ModelAndView();
        view.addObject("student", new Student());
        view.setViewName("student-create");

        return view;
    }

    @PostMapping(value = "/students")
    public ModelAndView create(@ModelAttribute Student student) {

        ModelAndView view = new ModelAndView();

        service.save(student);

        view.setViewName("redirect:/students");

        return view;
    }

    @GetMapping(value = "/students/{studentID}/update")
    public ModelAndView update(@PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();
        view.addObject("student", service.find(studentID));
        view.setViewName("student-update");

        return view;
    }

    @PostMapping(value = "/students/{studentID}")
    public ModelAndView update(@PathVariable(value = "studentID") long studentID,
                               @ModelAttribute Student student) {

        ModelAndView view = new ModelAndView();

        student.setId(studentID);
        service.update(student);

        view.setViewName("redirect:/students");

        return view;
    }

    @GetMapping(value = "/students/{studentID}/delete")
    public ModelAndView delete(@PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();

        service.delete(studentID);

        view.setViewName("redirect:/students");

        return view;
    }
}
