package checkmate.controller;


import checkmate.dto.StudentSubmissionDTO;
import checkmate.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/upload")
    public StudentSubmissionDTO uploadSubmission(
            @RequestParam Long studentId,
            @RequestParam Long examId,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        // For now, we’ll just mock the file storage path — integrate AWS/S3 later
        String path = "uploads/" + file.getOriginalFilename();
        file.transferTo(new java.io.File(path));

        return submissionService.uploadSubmission(studentId, examId, path);
    }

    @GetMapping("/{submissionId}")
    public StudentSubmissionDTO getSubmission(@PathVariable Long submissionId) {
        return submissionService.getSubmission(submissionId);
    }
}

