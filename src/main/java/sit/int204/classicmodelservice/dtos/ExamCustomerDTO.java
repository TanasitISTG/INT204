package sit.int204.classicmodelservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamCustomerDTO {
    private Integer customerNumber;
    private String contactFirstName;
    private String contactLastName;
}
