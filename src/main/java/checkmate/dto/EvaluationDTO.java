package checkmate.dto;

import java.time.LocalDateTime;

public record EvaluationDTO(
        Long id,
        Long questionId,
        Long segmentId,
        Double marksAwarded,
        Double maxMarks,
        Double confidence,
        String feedback,
        String evaluatorType,
        LocalDateTime evaluatedAt
) {}

