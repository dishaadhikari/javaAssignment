package com.assignment.Springboot.controller;

import com.assignment.Springboot.entity.Employee;
import com.assignment.Springboot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    private String id;

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employeeList")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    @GetMapping("/employee/{id}")
    public Employee fetchById(@PathVariable String id) {
        return employeeService.fetchById(id);
    }

    @PutMapping("/employee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }


}