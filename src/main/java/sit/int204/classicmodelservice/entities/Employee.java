package sit.int204.classicmodelservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(nullable = false)
    private Integer employeeNumber;
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee employee;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;
}
