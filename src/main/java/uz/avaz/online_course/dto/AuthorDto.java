package uz.avaz.online_course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
