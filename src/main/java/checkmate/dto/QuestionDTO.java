package checkmate.dto;

public record QuestionDTO(
        Long id,
        Integer questionNumber,
        String questionText,
        String sampleAnswer,
        Integer maxMarks,
        String difficultyLevel
) {}

