package checkmate.dto;

import java.time.LocalDateTime;

public record EvaluationAuditDTO(
        Long id,
        Long evaluationId,
        String action,
        String oldValues,
        String newValues,
        Long modifiedById,
        LocalDateTime modifiedAt
) {}

