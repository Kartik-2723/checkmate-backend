package checkmate.dto;

public record EvaluationRequest(
        Long evaluationId,
        Double newMarks,
        String feedback,
        Long modifiedBy
) {}

