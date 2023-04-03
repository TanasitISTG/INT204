package sit.int204.classicmodelservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.entities.Employee;
import sit.int204.classicmodelservice.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{employeeNumber}")
    public Employee getEmployeeById(@PathVariable Integer employeeNumber) {
        return employeeService.getEmployeeById(employeeNumber);
    }

    @PutMapping("/{employeeNumber}")
    public Employee updateEmployee(@PathVariable Integer employeeNumber, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeNumber, employee);
    }

    @DeleteMapping("/{employeeNumber}")
    public void deleteEmployee(@PathVariable Integer employeeNumber) {
        employeeService.deleteEmployee(employeeNumber);
    }
}
