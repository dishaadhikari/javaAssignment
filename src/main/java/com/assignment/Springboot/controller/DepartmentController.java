package com.assignment.Springboot.controller;

import com.assignment.Springboot.entity.Department;
import com.assignment.Springboot.entity.Employee;
import com.assignment.Springboot.service.DepartmentServiceImpl;
import com.assignment.Springboot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController

public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private EmployeeServiceImpl employeeService;


    @PostMapping("/department")
    public void createDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
    }


    @PostMapping("/employee/{employeeId}/department")
    public void saveDepartment(@PathVariable String employeeId, @RequestBody Department department) {


        Employee emp1 = employeeService.fetchById(employeeId);

        Department department1 = departmentService.getDepartmentById(department.getDepartmentId());
        Set<Employee> emp = department1.getEmployee();
        emp.add(emp1);
        department1.setEmployee(emp);
        departmentService.saveDepartment(department1);


    }

    @PutMapping("/departments")
    public void updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable("id") String id) {
        departmentService.deleteDepartment(id);
    }

    @RequestMapping(value = "/employee/{empId}/department/{departId}", method = RequestMethod.DELETE)
    public void deleteDepartmentFromEmployee(@PathVariable String empId, @PathVariable String departId) {
        Employee emp1 = employeeService.fetchById(empId);
        Department depart1 = departmentService.getDepartmentById(departId);
        Set<Employee> emp = depart1.getEmployee();
        emp.remove(emp1);
        depart1.setEmployee(emp);
        departmentService.updateDepartment(depart1);
    }

    @GetMapping("/department/list")
    public List<Department> getDepartment() {
        return departmentService.getDepartment();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") String id) {
        return departmentService.getDepartmentById(id);
    }
}
