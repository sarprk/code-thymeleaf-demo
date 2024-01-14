package com.javapractice.departmentservice.service.impl;

import com.javapractice.departmentservice.dto.DepartmentDto;
import com.javapractice.departmentservice.entity.Department;
import com.javapractice.departmentservice.repository.DepartmentRepository;
import com.javapractice.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto department) {
        var depEntity = modelMapper.map(department, Department.class);
        var savedEntity = departmentRepository.save(depEntity);
        return modelMapper.map(savedEntity, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        var department = departmentRepository.findById(id);
        return modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        var department = departmentRepository.findByDepartmentCode(departmentCode);
        return modelMapper.map(department, DepartmentDto.class);
    }
}
