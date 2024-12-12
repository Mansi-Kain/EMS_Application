package net.mansi.ems_backend.service;

import net.mansi.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(long id, EmployeeDto updatedEmployee);
    void deleteEmployee(Long id);
}
