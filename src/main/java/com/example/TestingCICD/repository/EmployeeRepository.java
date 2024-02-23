package com.example.TestingCICD.repository;

import com.example.TestingCICD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }