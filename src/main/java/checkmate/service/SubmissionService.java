package checkmate.service;

import checkmate.dto.StudentSubmissionDTO;

public interface SubmissionService {
    StudentSubmissionDTO uploadSubmission(Long studentId, Long examId, String filePath);
    StudentSubmissionDTO getSubmission(Long id);
}

