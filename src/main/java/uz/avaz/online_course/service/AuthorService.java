package uz.avaz.online_course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.avaz.online_course.dto.AuthorDto;
import uz.avaz.online_course.entitiy.User;
import uz.avaz.online_course.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    public List<AuthorDto> getAuthorByCourseId() {
        List<User> authors = authorRepository.findAll();
        return authorDtoFactory(authors);
    }

    private List<AuthorDto> authorDtoFactory(List<User> authors) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        for (User author : authors) {
            AuthorDto authorDto = new AuthorDto(
                    author.getId(),
                    author.getFirstName(),
                    author.getLastName(),
                    author.getEmail()
            );
            authorDtoList.add(authorDto);
        }
        return authorDtoList;
    }
}
