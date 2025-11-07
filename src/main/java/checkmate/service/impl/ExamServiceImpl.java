package checkmate.service.impl;

import checkmate.dto.*;
import checkmate.entity.*;
import checkmate.repository.*;
import checkmate.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    @Override
    public ExamDTO createExam(CreateExamRequest request) {
        User teacher = userRepository.findById(request.teacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Exam exam = Exam.builder()
                .title(request.title())
                .subject(request.subject())
                .createdBy(teacher)
                .status("DRAFT")
                .build();

        exam = examRepository.save(exam);

        Exam finalExam = exam;
        List<Question> questions = request.questions().stream()
                .map(q -> Question.builder()
                        .exam(finalExam)
                        .questionNumber(q.questionNumber())
                        .questionText(q.questionText())
                        .sampleAnswer(q.sampleAnswer())
                        .maxMarks(q.maxMarks())
                        .difficultyLevel(q.difficultyLevel())
                        .build())
                .collect(Collectors.toList());

        questionRepository.saveAll(questions);

        return new ExamDTO(
                exam.getId(),
                exam.getTitle(),
                exam.getSubject(),
                exam.getStatus(),
                new UserDTO(teacher.getId(), teacher.getName(), teacher.getEmail(), teacher.getRole()),
                request.questions()
        );
    }

    @Override
    public ExamDTO getExamById(Long id) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        List<QuestionDTO> questions = exam.getQuestions().stream()
                .map(q -> new QuestionDTO(
                        q.getId(),
                        q.getQuestionNumber(),
                        q.getQuestionText(),
                        q.getSampleAnswer(),
                        q.getMaxMarks(),
                        q.getDifficultyLevel()))
                .collect(Collectors.toList());

        return new ExamDTO(
                exam.getId(),
                exam.getTitle(),
                exam.getSubject(),
                exam.getStatus(),
                new UserDTO(
                        exam.getCreatedBy().getId(),
                        exam.getCreatedBy().getName(),
                        exam.getCreatedBy().getEmail(),
                        exam.getCreatedBy().getRole()),
                questions
        );
    }

    @Override
    public List<ExamDTO> getExamsByTeacher(Long teacherId) {
        User teacher = userRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return examRepository.findByCreatedBy(teacher).stream()
                .map(e -> new ExamDTO(
                        e.getId(),
                        e.getTitle(),
                        e.getSubject(),
                        e.getStatus(),
                        new UserDTO(teacher.getId(), teacher.getName(), teacher.getEmail(), teacher.getRole()),
                        null))
                .collect(Collectors.toList());
    }
}

