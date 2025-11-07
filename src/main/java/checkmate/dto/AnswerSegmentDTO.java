package checkmate.dto;

public record AnswerSegmentDTO(
        Long id,
        Integer pageNumber,
        String extractedText,
        String diagramPath,
        String boundingBox,
        Long questionId,
        String status
) {}
