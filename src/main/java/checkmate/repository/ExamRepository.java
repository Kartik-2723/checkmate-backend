package checkmate.repository;



import checkmate.entity.Exam;
import checkmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByCreatedBy(User teacher);
}

