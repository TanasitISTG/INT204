package sit.int204.classicmodelservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.entities.Order;
import sit.int204.classicmodelservice.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Page<Order> getOrders(int page, int size, String sortBy) {
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return orderRepository.findAll(pageable);
    }

    public Order createOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public Order getOrderById(Integer orderNumber) {
        return orderRepository.findById(orderNumber).orElseThrow(() -> new RuntimeException("Order Number " + orderNumber + " does not exist"));
    }

    public Order updateOrder(Order order, Integer orderNumber) {
        Order existOrder = getOrderById(orderNumber);

        existOrder.setOrderDate(order.getOrderDate());
        existOrder.setRequiredDate(order.getRequiredDate());
        existOrder.setShippedDate(order.getShippedDate());
        existOrder.setStatus(order.getStatus());
        existOrder.setComments(order.getComments());

        return orderRepository.saveAndFlush(existOrder);
    }

    public void deleteOrdersByCustomer(Customer customer) {
        orderRepository.deleteByCustomer(customer);
    }
}
