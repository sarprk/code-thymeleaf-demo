package com.javapractice.departmentservice.controller;

import com.javapractice.departmentservice.dto.DepartmentDto;
import com.javapractice.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping("save")
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto department)
    {
        var savedDept = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> GetDepartmentById(@PathVariable Long id)
    {
        var savedDept = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
    }

    @GetMapping("code/{department-code}")
    public ResponseEntity<DepartmentDto> GetDepartmentById(@PathVariable("department-code") String departmentCode)
    {
        var savedDept = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<>(savedDept, HttpStatus.OK);
    }
}
