package sit.int204.classicmodelservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.entities.Employee;
import sit.int204.classicmodelservice.entities.Office;
import sit.int204.classicmodelservice.services.OfficeService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/offices")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @GetMapping("")
    public List<Office> getAllOffices() {
        return officeService.getOffices();
    }

    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode) {
        return officeService.getOfficeById(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployee(@PathVariable String officeCode) {
        return officeService.getOfficeEmployee(officeCode);
    }

    @PostMapping("/{officeCode}/employees")
    public Employee createEmployee(@PathVariable String officeCode, @RequestBody Employee employee) {
        return officeService.createEmployee(officeCode, employee);
    }

    @PostMapping("")
    public Office createOffice(@RequestBody Office office) {
        return officeService.createOffice(office);
    }

    @DeleteMapping("/{officeCode}")
    public void deleteOffice(@PathVariable String officeCode) {
        officeService.deleteOffice(officeCode);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@PathVariable String officeCode, @RequestBody Office office) {
        return officeService.updateOffice(officeCode, office);
    }
}
