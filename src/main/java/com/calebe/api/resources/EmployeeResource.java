package com.calebe.api.resources;

import com.calebe.api.domain.Employee;
import com.calebe.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Valid
@RestController
@RequestMapping(path = "/api/employees")
//@RequiredArgsConstructor
public class EmployeeResource {
    @Qualifier(value = "mySQLEmployeeService")
    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//        employee.setId(employeeService.getAllEmployees().size() + 1);
        employeeService.addEmployee(employee);
        return ResponseEntity.created(getLocation(employee.getId())).body(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployees(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
