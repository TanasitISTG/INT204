package sit.int204.classicmodelservice.controllers;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.dtos.OrderDTO;
import sit.int204.classicmodelservice.dtos.PageDTO;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.entities.Order;
import sit.int204.classicmodelservice.services.OrderService;
import sit.int204.classicmodelservice.utils.ListMapper;

@RestController
@RequestMapping("api/64130500034/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public PageDTO<OrderDTO> getAllOrdersByPage(@RequestParam(defaultValue = "0") Integer page,
                                                @RequestParam(defaultValue = "15") Integer size,
                                                @RequestParam(defaultValue = "orderNumber") String sortBy) {
        Page<Order> orders = orderService.getOrders(page, size, sortBy);
        return listMapper.toPageDTO(orders, OrderDTO.class, modelMapper);
    }

    @PostMapping("")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{orderNumber}")
    public Order updateOrder(@PathVariable Integer orderNumber, @RequestBody Order order) {
        return orderService.updateOrder(order, orderNumber);
    }

    @DeleteMapping("")
    @Transactional
    public void deleteAllOrdersByCustomer(@RequestBody Customer customer) {
        orderService.deleteOrdersByCustomer(customer);
    }
}
