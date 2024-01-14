package com.javapractice.departmentservice.service;

import com.javapractice.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto department);
    DepartmentDto getDepartmentById(Long id);

    DepartmentDto getDepartmentByDepartmentCode(String departmentCode);
}
