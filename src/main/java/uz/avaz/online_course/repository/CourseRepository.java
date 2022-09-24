package uz.avaz.online_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avaz.online_course.entitiy.Course;


public interface CourseRepository extends JpaRepository<Course,Long> {
}
