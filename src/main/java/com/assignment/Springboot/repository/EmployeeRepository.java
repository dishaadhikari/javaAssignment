package com.assignment.Springboot.repository;

import com.assignment.Springboot.entity.Department;
import com.assignment.Springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    public Set<Employee> findByDepartments(Department department);

}
