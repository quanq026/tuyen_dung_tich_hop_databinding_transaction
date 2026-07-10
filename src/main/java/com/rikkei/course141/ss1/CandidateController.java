package com.rikkei.course141.ss1;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse<Candidate>> apply(@Valid @ModelAttribute CandidateApplyDTO dto) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(candidateService.apply(dto)));
    }
}
