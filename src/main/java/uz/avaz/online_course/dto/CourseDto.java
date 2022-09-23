package uz.avaz.online_course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {
    private Long id;
    private String name;
    private String description;
    private List<AuthorDto> authors;
    private LocalDateTime createdAt = LocalDateTime.now();
}
