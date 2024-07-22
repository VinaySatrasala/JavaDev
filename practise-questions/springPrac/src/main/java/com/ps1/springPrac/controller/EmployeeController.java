package com.ps1.springPrac.controller;

import com.ps1.springPrac.model.Employee;
import com.ps1.springPrac.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    public EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/students")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/students")
    public Employee addStudent(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @GetMapping("/students/{age}")
    public List<Employee> getStudent(@PathVariable int age) {
        return employeeService.getEmployeeByAge(age);
    }


}
