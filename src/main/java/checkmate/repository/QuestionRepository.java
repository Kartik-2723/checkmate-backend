package checkmate.repository;

import checkmate.entity.Question;
import checkmate.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByExam(Exam exam);
}
