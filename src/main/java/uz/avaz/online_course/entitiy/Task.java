package uz.avaz.online_course.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer taskNumber;

    private String degree;

    @ManyToOne
    private Lesson lesson;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "task")
    private List<Attachment> attachment;
}
