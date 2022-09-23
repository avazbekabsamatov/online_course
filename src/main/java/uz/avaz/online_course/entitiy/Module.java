package uz.avaz.online_course.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double price;

    @ManyToOne
    private Course course;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "module")
    private List<Lesson> lessons;
}
