package checkmate.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AnswerSegment segment;

    @ManyToOne
    private Question question;

    private Double marksAwarded;
    private Double maxMarks;
    private Double confidence; // confidence from ML/LLM

    @Column(length = 3000)
    private String feedback;

    private String evaluatorType; // AUTO or TEACHER

    private LocalDateTime evaluatedAt = LocalDateTime.now();
}

