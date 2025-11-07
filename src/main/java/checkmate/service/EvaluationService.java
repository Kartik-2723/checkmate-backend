package checkmate.service;

import checkmate.dto.EvaluationDTO;

public interface EvaluationService {
    EvaluationDTO evaluateSegment(Long segmentId);
    EvaluationDTO overrideEvaluation(Long evaluationId, Double newMarks, String feedback, Long teacherId);
}

