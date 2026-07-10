package com.rikkei.course141.ss1;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> create(@Valid @RequestBody EmployeeCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(employeeService.create(dto)));
    }

    @PutMapping("/{id}/avatar")
    public ResponseEntity<ApiResponse<Employee>> uploadAvatar(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(ApiResponse.success(employeeService.uploadAvatar(id, file)));
    }
}
