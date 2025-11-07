package checkmate.repository;



import checkmate.entity.EvaluationAudit;
import checkmate.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluationAuditRepository extends JpaRepository<EvaluationAudit, Long> {
    List<EvaluationAudit> findByEvaluation(Evaluation evaluation);
}
