package ua.com.alevel.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.GroupFacade;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.view.dto.request.StudentRequestDto;
import ua.com.alevel.view.dto.response.GroupResponseDto;
import ua.com.alevel.view.dto.response.PageData;
import ua.com.alevel.view.dto.response.StudentResponseDto;

@Controller
@RequestMapping("/students")
public class StudentController extends BaseController {

    private long update_id;
    private final GroupFacade groupFacade;
    private final StudentFacade studentFacade;
    private final HeaderName[] columnNames = new HeaderName[]{
            new HeaderName("№", null, null),
            new HeaderName("First name", "firstName", "first_name"),
            new HeaderName("Last name", "lastName", "last_name"),
            new HeaderName("Date created", "created", "created"),
            new HeaderName("Details", null, null),
            new HeaderName("Delete", null, null)
    };

    public StudentController(GroupFacade groupFacade, StudentFacade studentFacade) {
        this.groupFacade = groupFacade;
        this.studentFacade = studentFacade;
    }

    @GetMapping
    public String findAll(Model model, WebRequest request) {
        initDataTable(studentFacade.findAll(request), columnNames, model);
        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("createNew", "null");
        model.addAttribute("cardHeader", "All Students");
        return "pages/students/students_all";
    }

    @PostMapping("/all")
    public ModelAndView findAllRedirect(WebRequest request, ModelMap model) {
        return findAllRedirect(request, model, "students");
    }

    @GetMapping("/groups/{id}")
    public String findAllByGroup(Model model, @PathVariable Long id, WebRequest request) {
        model.addAttribute("group", groupFacade.findById(id));
        initDataTable(studentFacade.findAllStudentsByGroup(request, id), columnNames, model);
        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("createNew", "/students/new/" + id);
        model.addAttribute("cardHeader", "All Students");
        return "pages/students/students_in_group";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        StudentResponseDto dto = studentFacade.findById(id);
        model.addAttribute("student", dto);
        return "pages/students/student_details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentFacade.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String updateStudentPage(@PathVariable Long id, @ModelAttribute("student") StudentRequestDto dto, Model model, WebRequest request) {
        update_id = id;
        PageData<GroupResponseDto> groups = groupFacade.findAll(request);

        model.addAttribute("groupsList", groupFacade.findAll(request));
        return "pages/students/student_update";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") StudentRequestDto dto) {
        studentFacade.update(dto, update_id);
        return "redirect:/students";
    }

    @GetMapping("/new/{id}")
    public String redirectToNewStudentPage(Model model, @PathVariable Long id) {
        StudentRequestDto student = new StudentRequestDto();
        student.setGroupId(id);
        model.addAttribute("student", student);
        return "pages/students/student_new";
    }

    @PostMapping("/new")
    public String createNewStudent(@ModelAttribute("group") StudentRequestDto dto) {
        studentFacade.create(dto);
        return "redirect:/students/groups/" + dto.getGroupId();
    }
}
