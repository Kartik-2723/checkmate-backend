package checkmate.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer questionNumber;

    @Column(length = 2000)
    private String questionText;

    @Column(length = 5000)
    private String sampleAnswer;

    private Integer maxMarks;

    private String difficultyLevel; // EASY, MEDIUM, HARD

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}

