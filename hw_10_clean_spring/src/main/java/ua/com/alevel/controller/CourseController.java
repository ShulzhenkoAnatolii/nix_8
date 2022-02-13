package ua.com.alevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseName;
import ua.com.alevel.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String all(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/course_all";
    }

    @GetMapping("/new")
    public String redirectToNew(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("courseNames", CourseName.values());
        return "course/course_new";
    }

    @PostMapping("/new")
    public String newCourse(@ModelAttribute Course course) {
        courseService.create(course);
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String updateCoursePage(@PathVariable Integer id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("courseNames", CourseName.values());
        return "course/course_update";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@ModelAttribute Course course) {
        courseService.update(course);
        return "redirect:/courses";
    }
}