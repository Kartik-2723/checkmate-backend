package checkmate.controller;

import checkmate.dto.CreateExamRequest;
import checkmate.dto.ExamDTO;
import checkmate.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public ExamDTO createExam(@RequestBody CreateExamRequest request) {
        return examService.createExam(request);
    }

    @GetMapping("/{examId}")
    public ExamDTO getExam(@PathVariable Long examId) {
        return examService.getExamById(examId);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<ExamDTO> getExamsByTeacher(@PathVariable Long teacherId) {
        return examService.getExamsByTeacher(teacherId);
    }
}

