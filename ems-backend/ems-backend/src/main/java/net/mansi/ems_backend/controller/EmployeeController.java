package net.mansi.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.mansi.ems_backend.dto.EmployeeDto;
import net.mansi.ems_backend.repository.EmployeeRepository;
import net.mansi.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Rest API to create Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody  EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto) , HttpStatus.CREATED);
    }

    //Rest API to get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    //REST API to get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees =employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //REST API to update employee
    @PutMapping ("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody  EmployeeDto updatedEmployee){
        EmployeeDto employeeDto= employeeService.updateEmployee(id,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Rest API to delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted Successfully");
    }
}
