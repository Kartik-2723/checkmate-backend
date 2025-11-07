package checkmate.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private User createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String status; // DRAFT, ACTIVE, CLOSED

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Question> questions;
}

