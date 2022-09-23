package uz.avaz.online_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.avaz.online_course_app.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllCourse(Model model,
    @RequestParam(required = false,defaultValue = "1") Integer page) {
    model.addAttribute("courseList",courseService.getAllCourse(page));
    return "view-course";
    }
}
