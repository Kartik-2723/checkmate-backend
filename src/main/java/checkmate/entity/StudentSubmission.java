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
public class StudentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User student;

    @ManyToOne
    private Exam exam;

    private String originalFilePath; // link to uploaded file (S3/local path)
    private String processedFilePath; // link after preprocessing

    private String status; // UPLOADED, PROCESSING, READY, REVIEWED

    private LocalDateTime uploadedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    private List<AnswerSegment> segments;
}

