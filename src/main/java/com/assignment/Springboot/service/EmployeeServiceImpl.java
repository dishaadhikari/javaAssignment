package com.assignment.Springboot.service;

import com.assignment.Springboot.entity.Department;
import com.assignment.Springboot.entity.Employee;
import com.assignment.Springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }


    public Employee fetchById(String id) {
        return employeeRepository.getById(id);
    }


    public void updateEmployee(Employee employee) {
        Employee emp=employeeRepository.getById(employee.getEmployeeId());
        emp.setEmployeeEmail(employee.getEmployeeEmail());
        emp.setEmployeename(employee.getEmployeename());

        employeeRepository.save(emp);
    }


    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);

    }


    public Set<Employee> findByDepartments(Department department) {
        return employeeRepository.findByDepartments(department);
    }


}
