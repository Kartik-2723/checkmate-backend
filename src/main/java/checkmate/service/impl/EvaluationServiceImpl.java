package checkmate.service.impl;

import checkmate.dto.EvaluationDTO;
import checkmate.entity.*;
import checkmate.repository.*;
import checkmate.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final AnswerSegmentRepository segmentRepository;
    private final EvaluationRepository evaluationRepository;
    private final EvaluationAuditRepository auditRepository;
    private final UserRepository userRepository;

    @Override
    public EvaluationDTO evaluateSegment(Long segmentId) {
        // Placeholder for AI/LLM integration
        AnswerSegment segment = segmentRepository.findById(segmentId)
                .orElseThrow(() -> new RuntimeException("Segment not found"));

        // Example mocked evaluation logic
        Evaluation eval = Evaluation.builder()
                .segment(segment)
                .question(segment.getQuestion())
                .marksAwarded(6.5)
                .maxMarks(segment.getQuestion().getMaxMarks().doubleValue())
                .confidence(0.82)
                .feedback("Answer is mostly correct; missing one example.")
                .evaluatorType("AUTO")
                .evaluatedAt(LocalDateTime.now())
                .build();

        eval = evaluationRepository.save(eval);

        return new EvaluationDTO(
                eval.getId(),
                eval.getQuestion().getId(),
                eval.getSegment().getId(),
                eval.getMarksAwarded(),
                eval.getMaxMarks(),
                eval.getConfidence(),
                eval.getFeedback(),
                eval.getEvaluatorType(),
                eval.getEvaluatedAt()
        );
    }

    @Override
    public EvaluationDTO overrideEvaluation(Long evaluationId, Double newMarks, String feedback, Long teacherId) {
        Evaluation evaluation = evaluationRepository.findById(evaluationId)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
        User teacher = userRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        String oldValues = String.format("{marks:%s,feedback:%s}", evaluation.getMarksAwarded(), evaluation.getFeedback());

        evaluation.setMarksAwarded(newMarks);
        evaluation.setFeedback(feedback);
        evaluation.setEvaluatorType("TEACHER");
        evaluationRepository.save(evaluation);

        EvaluationAudit audit = EvaluationAudit.builder()
                .evaluation(evaluation)
                .action("TEACHER_OVERRIDE")
                .oldValues(oldValues)
                .newValues(String.format("{marks:%s,feedback:%s}", newMarks, feedback))
                .modifiedBy(teacher)
                .modifiedAt(LocalDateTime.now())
                .build();

        auditRepository.save(audit);

        return new EvaluationDTO(
                evaluation.getId(),
                evaluation.getQuestion().getId(),
                evaluation.getSegment().getId(),
                evaluation.getMarksAwarded(),
                evaluation.getMaxMarks(),
                evaluation.getConfidence(),
                evaluation.getFeedback(),
                evaluation.getEvaluatorType(),
                evaluation.getEvaluatedAt()
        );
    }
}
