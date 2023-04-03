package sit.int204.classicmodelservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Product;
import sit.int204.classicmodelservice.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String productCode) {
        return productRepository.findById(productCode).orElseThrow(() -> new RuntimeException("Product Code " + productCode + " does not exist"));
    }

    public Page<Product> getProducts(int page, int size, String sortBy) {
        Sort sort = Sort.by(sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }

    public List<Product> getProductBetweenRange(double low, double high) {
        if (low > high) {
            return productRepository.findAllByPriceBetweenOrderByPriceDesc(high, low);
        } else {
            return productRepository.findAllByPriceBetweenOrderByPriceDesc(low, high);
        }
    }

    public List<Product> getProductsSortByProductLine(String productLine, String sortBy) {
        return productRepository.findAllByProductLineContains(productLine, Sort.by(sortBy));
    }

    public Product updateProduct(Product product, String productCode) {
        Product existProduct = getProductById(productCode);

        existProduct.setProductLine(product.getProductLine());
        existProduct.setProductName(product.getProductName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());

        return productRepository.saveAndFlush(existProduct);
    }

    public Product createProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
