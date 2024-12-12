package net.mansi.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.mansi.ems_backend.dto.EmployeeDto;
import net.mansi.ems_backend.entities.Employee;
import net.mansi.ems_backend.exception.ResourceNotFoundException;
import net.mansi.ems_backend.mapper.EmployeeMapper;
import net.mansi.ems_backend.repository.EmployeeRepository;
import net.mansi.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

//    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
//        this.employeeRepository =employeeRepository;
//    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.
                findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List <Employee> employees =employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(long id ,EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.
                findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Employee not found")
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Employee not found")
                );
        employeeRepository.deleteById(id);
    }
}
