package com.javapractice.employeeservice.service.impl;

import com.javapractice.employeeservice.dto.APIResponseDto;
import com.javapractice.employeeservice.dto.DepartmentDto;
import com.javapractice.employeeservice.dto.EmployeeDto;
import com.javapractice.employeeservice.entity.Employee;
import com.javapractice.employeeservice.repository.EmployeeRepository;
import com.javapractice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    //    private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee newEmp = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        var savedEmployee = employeeRepository.save(newEmp);

        return new EmployeeDto(savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode());
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        var emp = employeeRepository.findById(id).get();

        var employeeDto = new EmployeeDto(emp.getId(), emp.getFirstName(),
                emp.getLastName(), emp.getEmail(),
                emp.getDepartmentCode());
        String url = "http://localhost:8085/api/department/code/" + emp.getDepartmentCode();
//        ResponseEntity<DepartmentDto> dept = restTemplate.getForEntity(url,
//                DepartmentDto.class);
        DepartmentDto departmentDto = webClient.get().uri(url).retrieve().
                bodyToMono(DepartmentDto.class).block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
