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
public class EvaluationAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evaluation evaluation;

    private String action; // CREATED, AUTO_UPDATED, TEACHER_OVERRIDE

    private String oldValues; // JSON string for audit
    private String newValues; // JSON string for audit

    @ManyToOne
    private User modifiedBy;

    private LocalDateTime modifiedAt = LocalDateTime.now();
}
