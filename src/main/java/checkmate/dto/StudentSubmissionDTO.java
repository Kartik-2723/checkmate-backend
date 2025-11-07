package checkmate.dto;

import java.time.LocalDateTime;
import java.util.List;

public record StudentSubmissionDTO(
        Long id,
        Long examId,
        UserDTO student,
        String originalFilePath,
        String processedFilePath,
        String status,
        LocalDateTime uploadedAt,
        List<AnswerSegmentDTO> segments
) {}

