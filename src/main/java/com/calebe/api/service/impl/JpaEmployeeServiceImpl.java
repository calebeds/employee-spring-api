package com.calebe.api.service.impl;

import com.calebe.api.domain.Employee;
import com.calebe.api.repository.JpaEmployeeRepository;
import com.calebe.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {
   private final JpaEmployeeRepository jpaEmployeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        jpaEmployeeRepository.findById(employee.getId()).get();
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
