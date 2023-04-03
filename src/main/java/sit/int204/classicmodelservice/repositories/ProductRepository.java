package sit.int204.classicmodelservice.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelservice.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByPriceBetweenOrderByPriceDesc(Double low, Double high);
    List<Product> findAllByProductLineContains(String productLine, Sort sort);
}
