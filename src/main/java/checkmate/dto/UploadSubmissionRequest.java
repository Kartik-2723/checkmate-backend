package checkmate.dto;

public record UploadSubmissionRequest(
        Long studentId,
        Long examId
) {}
