package sit.int204.classicmodelservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String productLine;
    @Column(name = "MSRP")
    private Double price;
    @Column(name = "quantityInStock")
    private Integer quantity;
}
