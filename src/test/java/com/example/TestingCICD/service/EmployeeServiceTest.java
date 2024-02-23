package com.example.TestingCICD.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.TestingCICD.dto.EmployeeDto;
import com.example.TestingCICD.entity.Employee;
import com.example.TestingCICD.repository.EmployeeRepository;
import com.example.TestingCICD.service.imple.EmployeeServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeServiceImple employeeService;

    @Test
    public void EmployeeService_CreateEmployee_ReturnEmployeeDto() {
        // Arrange
        Employee employee = Employee.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        EmployeeDto employeeDto = EmployeeDto.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        // Mock
        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
        // Act
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        // Assert
        Assertions.assertThat(createdEmployee).isNotNull();
    }

    @Test
    public void EmployeeService_GetAllEmployees_ReturnsListOfEmployees() {
        // Arrange
        Employee employee1 = Employee.builder().id(1).firstName("Manu").lastName("KM").email("mc@gmail.com").build();
        Employee employee2 = Employee.builder().id(2).firstName("Ragnar").lastName("Lothbr0ok").email("av@gmail.com").build();
        //MOCK
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));
        // ACT
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        // Assert
        Assertions.assertThat(allEmployees).isNotNull();
    }

    @Test
    public void EmployeeService_GetEmployeeById_ReturnEmployeeDto() {
        // Arrange
        Employee employee = Employee.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        // Mock
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        // Act
        EmployeeDto retrivedEmployee = employeeService.getEmployeeById(1L);
        // Assert
        Assertions.assertThat(retrivedEmployee).isNotNull();
    }

    @Test
    public void EmployeeService_UpdateEmployee_ReturnEmployeeDto() {
        // Arrange
        Employee employee = Employee.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        EmployeeDto employeeDto = EmployeeDto.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        // Mock
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
        // Act
        EmployeeDto updatedEmployee = employeeService.updateEmployee(1L, employeeDto);
        // Assert
        Assertions.assertThat(updatedEmployee).isNotNull();
    }

    @Test
    public void EmployeeService_DeleteEmployee_() {
        // Arrange
        Employee employee = Employee.builder().firstName("Manu").lastName("KM").email("manukm@gmail.com").build();
        // Mock
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        // Act
        EmployeeDto retrivedEmployee = employeeService.getEmployeeById(1L);
        // Assert
        assertAll(() -> employeeRepository.deleteById(1L));
    }
}