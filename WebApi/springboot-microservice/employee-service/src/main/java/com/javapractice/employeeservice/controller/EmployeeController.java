package com.javapractice.employeeservice.controller;

import com.javapractice.employeeservice.dto.APIResponseDto;
import com.javapractice.employeeservice.dto.EmployeeDto;
import com.javapractice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee)
    {
        var result = employeeService.saveEmployee(employee);
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getById(@PathVariable Long id)
    {
       var result= employeeService.getEmployeeById(id);
       return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
