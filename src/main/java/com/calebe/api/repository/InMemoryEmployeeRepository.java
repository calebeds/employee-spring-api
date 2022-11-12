package com.calebe.api.repository;

import com.calebe.api.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1, "John", "Smith", "john@email.com"));
        DATABASE.add(new Employee(2, "Alex", "Raymond", "alex@email.com"));
        DATABASE.add(new Employee(3, "David", "Cameron", "david@email.com"));
    }
    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    };

    public List<Employee> getAllEmployees(){
        return List.copyOf(DATABASE);
    };

    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElseThrow();
    };

    public Employee updateEmployee(Employee employee) {
        if(findById(employee.getId()) != null) {
            DATABASE.add(employee.getId(), employee);
            return employee;
        }
        return employee;
    };

    public Boolean deleteById(Integer id) {
      if(findById(id) != null) {
          DATABASE.remove(id);
          return Boolean.TRUE;
      }
      return false;
    };

}
