package checkmate.controller;


import checkmate.dto.EvaluationDTO;
import checkmate.dto.EvaluationRequest;
import checkmate.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/auto/{segmentId}")
    public EvaluationDTO evaluateSegment(@PathVariable Long segmentId) {
        return evaluationService.evaluateSegment(segmentId);
    }

    @PostMapping("/override")
    public EvaluationDTO overrideEvaluation(@RequestBody EvaluationRequest request) {
        return evaluationService.overrideEvaluation(
                request.evaluationId(),
                request.newMarks(),
                request.feedback(),
                request.modifiedBy()
        );
    }
}

