package checkmate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer pageNumber;

    @Column(length = 5000)
    private String extractedText;

    private String diagramPath; // optional diagram image path
    private String boundingBox; // JSON string {x, y, w, h}

    @ManyToOne
    private Question question;

    @ManyToOne
    private StudentSubmission submission;

    private String status; // PENDING, MAPPED, EVALUATED
}

