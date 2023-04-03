package sit.int204.classicmodelservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelservice.entities.Product;
import sit.int204.classicmodelservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Page<Product> getProductPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "15") Integer size,
            @RequestParam(defaultValue = "productName") String sortBy)
    {
        return productService.getProducts(page, size, sortBy);
    }

    @GetMapping("/{low}/{high}")
    public List<Product> getProductsBetweenRange(@PathVariable Double low, @PathVariable Double high) {
        return productService.getProductBetweenRange(low, high);
    }

    @GetMapping("/{productLine}")
    public List<Product> getProductsByProductLine(@PathVariable String productLine, @RequestParam(defaultValue = "productName") String sortBy) {
        return productService.getProductsSortByProductLine(productLine, sortBy);
    }

    @PutMapping("/{productCode}")
    public Product updateProduct(@PathVariable String productCode, @RequestBody Product product) {
        return productService.updateProduct(product, productCode);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}