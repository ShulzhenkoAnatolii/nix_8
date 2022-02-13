package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDao studentDao;

    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("students", studentDao.findAll());
        return "student/students_all";
    }

    @GetMapping("/new")
    public String redirectToNew(Model model) {
        model.addAttribute("student", new Student());
        //model.addAttribute("studentNames", StudentName.values());
        return "course/course_new";
    }

    @PostMapping("/new")
    public String newCourse(@ModelAttribute Student student) {
        studentDao.create(student);
        return "redirect:/students";
    }
}