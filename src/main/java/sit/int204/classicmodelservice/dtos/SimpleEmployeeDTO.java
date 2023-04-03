package sit.int204.classicmodelservice.dtos;

import lombok.Setter;

@Setter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;

    public String getName() {
        return firstName + " " + lastName;
    }
}
