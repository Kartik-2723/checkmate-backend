package checkmate.repository;

import checkmate.entity.Evaluation;
import checkmate.entity.AnswerSegment;
import checkmate.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByQuestion(Question question);
    List<Evaluation> findBySegment(AnswerSegment segment);
}

