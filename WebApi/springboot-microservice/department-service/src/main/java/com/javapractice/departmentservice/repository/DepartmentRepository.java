package com.javapractice.departmentservice.repository;

import com.javapractice.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentCode(String departmentCode);
}
