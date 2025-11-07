package checkmate.repository;

import checkmate.entity.StudentSubmission;
import checkmate.entity.Exam;
import checkmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentSubmissionRepository extends JpaRepository<StudentSubmission, Long> {
    List<StudentSubmission> findByStudent(User student);
    List<StudentSubmission> findByExam(Exam exam);
}

