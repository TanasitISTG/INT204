package sit.int204.classicmodelservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(Integer customerNumber) {
        return customerRepository.findById(customerNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID: " + customerNumber + " not found"));
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Page<Customer> getCustomersByPage(Integer page, Integer size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }
}
