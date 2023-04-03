package sit.int204.classicmodelservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Employee;
import sit.int204.classicmodelservice.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber).orElseThrow(() -> new RuntimeException("Employee Id " + employeeNumber + " does not exist"));
    }

    public Employee updateEmployee(Integer employeeNumber, Employee employee) {
        Employee existEmployee = getEmployeeById(employeeNumber);

        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setExtension(employee.getExtension());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setJobTitle(employee.getJobTitle());

        return employeeRepository.saveAndFlush(existEmployee);
    }

    public void deleteEmployee(Integer employeeNumber) {
        if (employeeRepository.existsById(employeeNumber)) {
            employeeRepository.deleteById(employeeNumber);
        } else {
            throw new RuntimeException("Employee Id " + employeeNumber + " does not exist");
        }
    }
}
