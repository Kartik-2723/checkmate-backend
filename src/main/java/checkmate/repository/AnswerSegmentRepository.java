package checkmate.repository;



import checkmate.entity.AnswerSegment;
import checkmate.entity.StudentSubmission;
import checkmate.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnswerSegmentRepository extends JpaRepository<AnswerSegment, Long> {
    List<AnswerSegment> findBySubmission(StudentSubmission submission);
    List<AnswerSegment> findByQuestion(Question question);
}

