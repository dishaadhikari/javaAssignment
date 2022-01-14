package com.assignment.Springboot.entity;

import com.assignment.Springboot.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Employee extends Auditable<String> {
    @Id
    private String employeeId;
    private String employeename;

    private String employeeEmail;
    @ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private Set<Department> departments;

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }


    public Employee() {
    }

    public Employee(String employeeId, String employeename, String employeeDepartmentId, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeename = employeename;

        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeename='" + employeename + '\'' +

                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
