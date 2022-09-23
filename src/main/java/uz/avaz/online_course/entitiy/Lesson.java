package uz.avaz.online_course.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String body;

    @ManyToOne
    private Module module;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lesson")
    private List<Task> tasks;

}
