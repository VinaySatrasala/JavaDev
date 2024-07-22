package com.ps1.springPrac.service;

import com.ps1.springPrac.model.Employee;
import com.ps1.springPrac.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeByAge(int age) {
        return employeeRepository.findEmployeesByAge(age);
    }
}
