package checkmate.dto;

import java.util.List;

public record ExamDTO(
        Long id,
        String title,
        String subject,
        String status,
        UserDTO createdBy,
        List<QuestionDTO> questions
) {}

