package ua.com.alevel.util.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.persistence.dao.impl.StudentDaoImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDaoImpl studentDao;

    public StudentController(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping
    public String findAll(Model model){
        return null;
    }
}
