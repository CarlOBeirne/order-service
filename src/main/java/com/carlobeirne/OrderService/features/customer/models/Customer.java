package com.carlobeirne.OrderService.features.customer.models;

import com.carlobeirne.OrderService.features.address.models.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "email_address", length = 100)
    @NotBlank(message = "Email address cannot be empty")
    @Email(message = "Email address must be in a valid format")
    private String emailAddress;

    @Column(name = "first_name", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    // TODO: Create validator for date
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    // TODO: Create validator for phone number
    @Column(name = "mobile_no", nullable = false)
    private Long mobileNo;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Builder.Default
    @ToString.Exclude
    @JoinTable(
            name = "customer_address",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "email_address"),
            inverseJoinColumns = @JoinColumn(name= "address_id")
    )
    private Set<Address> addresses = new HashSet<>();
}