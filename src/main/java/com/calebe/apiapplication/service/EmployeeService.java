package com.calebe.apiapplication.service;

import com.calebe.apiapplication.domain.Employee;

import java.util.List;

public interface EmployeeService {
    // Save an employee
    Employee addEmployee(Employee employee);

    // Get employees
    List<Employee> getAllEmployees();

    // Get one employee
    Employee findById(Integer id);

    // Update an employee
    Employee updateEmployee(Employee employee);

    // Delete employee
    Boolean deleteById(Integer id);
}
