package com.assignment.Springboot.service;

import com.assignment.Springboot.entity.Department;
import com.assignment.Springboot.entity.Employee;
import com.assignment.Springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service

public class DepartmentServiceImpl {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }


    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }


    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }


    public Department getDepartmentById(String id) {
        return departmentRepository.getById(id);
    }


    public Set<Department> findByEmployee(Employee employee) {
        return departmentRepository.findByEmployee(employee);
    }


}
