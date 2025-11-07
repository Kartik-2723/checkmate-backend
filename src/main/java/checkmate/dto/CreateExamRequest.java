package checkmate.dto;

import java.util.List;

public record CreateExamRequest(
        String title,
        String subject,
        Long teacherId,
        List<QuestionDTO> questions
) {}

