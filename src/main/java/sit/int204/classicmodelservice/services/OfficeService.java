package sit.int204.classicmodelservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Employee;
import sit.int204.classicmodelservice.entities.Office;
import sit.int204.classicmodelservice.repositories.EmployeeRepository;
import sit.int204.classicmodelservice.repositories.OfficeRepository;

import java.util.List;
import java.util.Set;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(String officeCode) {
        return officeRepository.findById(officeCode).orElseThrow(() -> new RuntimeException("Office Id " + officeCode + " does not exist"));
    }

    public Set<Employee> getOfficeEmployee(String officeCode) {
        Office existOffice = getOfficeById(officeCode);
        return existOffice.getEmployees();
    }

    public Employee createEmployee(String officeCode, Employee employee) {
        Office existOffice = getOfficeById(officeCode);
        employee.setOffice(existOffice);
        return employeeRepository.saveAndFlush(employee);
    }

    public Office createOffice(Office office) {
        return officeRepository.saveAndFlush(office);
    }

    public void deleteOffice(String officeCode) {
        if (officeRepository.existsById(officeCode)) {
            officeRepository.deleteById(officeCode);
        } else {
            throw new RuntimeException("Office Id " + officeCode + " does not exist");
        }
    }

    public Office updateOffice(String officeCode, Office office) {
        Office existOffice = getOfficeById(officeCode);

        existOffice.setCity(office.getCity());
        existOffice.setPhone(office.getPhone());
        existOffice.setAddressLine1(office.getAddressLine1());
        existOffice.setAddressLine2(office.getAddressLine2());
        existOffice.setState(office.getState());
        existOffice.setCountry(office.getCountry());
        existOffice.setPostalCode(office.getPostalCode());
        existOffice.setTerritory(office.getTerritory());

        return officeRepository.saveAndFlush(existOffice);
    }
}
