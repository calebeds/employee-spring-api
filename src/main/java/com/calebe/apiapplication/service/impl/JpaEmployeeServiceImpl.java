package com.calebe.apiapplication.service.impl;

import com.calebe.apiapplication.domain.Employee;
import com.calebe.apiapplication.repository.JpaEmployeeRepository;
import com.calebe.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
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
