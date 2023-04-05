package sit.int204.classicmodelservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer orderNumber;
    private String orderDate;
    private String status;

    @JsonIgnore
    private ExamCustomerDTO customer;

    public String getCustomerDescription() {
        return customer == null ? "" : customer.getCustomerNumber() + "-" + customer.getContactFirstName() + " " + customer.getContactLastName();
    }
}
