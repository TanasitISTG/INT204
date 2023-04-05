package sit.int204.classicmodelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    void deleteByCustomer(Customer customer);
}
