package com.example.TestingCICD.service;

import com.example.TestingCICD.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto);
    void deleteEmployee(Long employeeId);
}
