
package checkmate.service;

import checkmate.dto.CreateExamRequest;
import checkmate.dto.ExamDTO;
import java.util.List;

public interface ExamService {
    ExamDTO createExam(CreateExamRequest request);
    ExamDTO getExamById(Long id);
    List<ExamDTO> getExamsByTeacher(Long teacherId);
}

