package com.dkovalenko.hibernatedemo.controller;

import com.dkovalenko.hibernatedemo.entity.Student;
import com.dkovalenko.hibernatedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ModelAndView find() {

        ModelAndView view = new ModelAndView();
        view.addObject("students", studentService.find());
        view.addObject("student", new Student());
        view.setViewName("index");

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

        studentService.save(student);

        view.setViewName("redirect:/students");

        return view;
    }

    @GetMapping(value = "/students/{studentID}/update")
    public ModelAndView update(@PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();
        view.addObject("student", studentService.find(studentID));
        view.setViewName("student-update");

        return view;
    }

    @PostMapping(value = "/students/{studentID}")
    public ModelAndView update(@ModelAttribute Student student,
                               @PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();

        student.setStudentID(studentID);
        studentService.update(student, studentID);

        view.setViewName("redirect:/students");

        return view;
    }

    @GetMapping(value = "/students/{studentID}/delete")
    public ModelAndView delete(@PathVariable(value = "studentID") long studentID) {

        ModelAndView view = new ModelAndView();

        studentService.delete(studentID);

        view.setViewName("redirect:/students");

        return view;
    }
}
