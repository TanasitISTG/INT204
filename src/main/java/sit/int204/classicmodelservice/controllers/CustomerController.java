package sit.int204.classicmodelservice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.dtos.PageDTO;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelservice.services.CustomerService;
import sit.int204.classicmodelservice.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public List<SimpleCustomerDTO> getAllCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return customers.stream().map(customer -> modelMapper.map(customer, SimpleCustomerDTO.class)).toList();
    }

    @GetMapping("/pages")
    public PageDTO<SimpleCustomerDTO> getAllCustomersByPage() {
        Page<Customer> customers = customerService.getCustomersByPage(0, 5);
        return listMapper.toPageDTO(customers, SimpleCustomerDTO.class, modelMapper);
    }

    @GetMapping("/{customerNumber}")
    public SimpleCustomerDTO getSimpleCustomerById(@PathVariable Integer customerNumber) {
        return modelMapper.map(customerService.getCustomerById(customerNumber), SimpleCustomerDTO.class);
    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
}
