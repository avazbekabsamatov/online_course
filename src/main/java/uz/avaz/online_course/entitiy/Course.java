package uz.avaz.online_course.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private Boolean status;

    private LocalDateTime createdAt = LocalDateTime.now();


    @ManyToMany
    @JoinTable(
            name = "courses_users",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> authors;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Module> modules;

    @OneToOne
    private Attachment attachment;
}
