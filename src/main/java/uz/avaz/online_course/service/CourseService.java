package uz.avaz.online_course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.avaz.online_course.dto.AuthorDto;
import uz.avaz.online_course.dto.CourseDto;
import uz.avaz.online_course.entitiy.Course;
import uz.avaz.online_course.entitiy.User;
import uz.avaz.online_course.repository.CourseRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    public final int limit = 3;
    private CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> getAllCourse(Integer page) {
        List<Course> courses = courseRepository
                .findAll(PageRequest.of(page - 1,limit)).get().toList();
        return courseDtoFactory(courses);
    }

    private List<CourseDto> courseDtoFactory(List<Course> courses) {
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (Course course : courses) {
            for (User author : course.getAuthors()) {
            AuthorDto authorDto = new AuthorDto
                    (author.getId(),
                    author.getFirstName(),
                    author.getLastName(),
                    author.getEmail());
            authorDtoList.add(authorDto);
            }
        CourseDto courseDto = new CourseDto(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getStatus(),
                authorDtoList,
                course.getCreatedAt()
                );
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }
}
