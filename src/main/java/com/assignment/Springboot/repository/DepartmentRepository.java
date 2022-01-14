package com.assignment.Springboot.repository;

import com.assignment.Springboot.entity.Department;
import com.assignment.Springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartmentRepository extends  JpaRepository<Department, String> {
    public Set<Department> findByEmployee(Employee employee);
}
