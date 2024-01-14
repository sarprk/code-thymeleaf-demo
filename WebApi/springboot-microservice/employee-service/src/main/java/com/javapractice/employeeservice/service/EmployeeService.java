package com.javapractice.employeeservice.service;

import com.javapractice.employeeservice.dto.APIResponseDto;
import com.javapractice.employeeservice.dto.EmployeeDto;
import com.javapractice.employeeservice.repository.EmployeeRepository;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
