package checkmate.service.impl;

import checkmate.dto.*;
import checkmate.entity.*;
import checkmate.repository.*;
import checkmate.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final StudentSubmissionRepository submissionRepository;
    private final UserRepository userRepository;
    private final ExamRepository examRepository;

    @Override
    public StudentSubmissionDTO uploadSubmission(Long studentId, Long examId, String filePath) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        StudentSubmission submission = StudentSubmission.builder()
                .student(student)
                .exam(exam)
                .originalFilePath(filePath)
                .status("UPLOADED")
                .build();

        submission = submissionRepository.save(submission);

        return new StudentSubmissionDTO(
                submission.getId(),
                exam.getId(),
                new UserDTO(student.getId(), student.getName(), student.getEmail(), student.getRole()),
                submission.getOriginalFilePath(),
                submission.getProcessedFilePath(),
                submission.getStatus(),
                submission.getUploadedAt(),
                Collections.emptyList()
        );
    }

    @Override
    public StudentSubmissionDTO getSubmission(Long id) {
        StudentSubmission sub = submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));

        return new StudentSubmissionDTO(
                sub.getId(),
                sub.getExam().getId(),
                new UserDTO(sub.getStudent().getId(), sub.getStudent().getName(), sub.getStudent().getEmail(), sub.getStudent().getRole()),
                sub.getOriginalFilePath(),
                sub.getProcessedFilePath(),
                sub.getStatus(),
                sub.getUploadedAt(),
                Collections.emptyList()
        );
    }
}

