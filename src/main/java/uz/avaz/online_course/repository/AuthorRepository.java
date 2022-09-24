package uz.avaz.online_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avaz.online_course.entitiy.User;

public interface AuthorRepository extends JpaRepository<User,Long> {
}
