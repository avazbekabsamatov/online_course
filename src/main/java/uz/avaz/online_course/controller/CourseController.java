package uz.avaz.online_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.avaz.online_course.service.AuthorService;
import uz.avaz.online_course.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;
    private AuthorService authorService;

    @Autowired
    public CourseController(CourseService courseService,AuthorService authorService) {
        this.courseService = courseService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getAllCourse(Model model,
    @RequestParam(required = false,defaultValue = "1") Integer page) {
    model.addAttribute("courses",courseService.getAllCourse(page));
    model.addAttribute("authors",authorService.getAuthorByCourseId());
    return "view-course";
    }
}
