package com.rikkei.course141.ss1;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department create(DepartmentCreateDTO dto) {
        Department d = Department.builder().name(dto.getName()).description(dto.getDescription()).build();
        return departmentRepository.save(d);
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Phòng ban không tồn tại"));
    }
}
