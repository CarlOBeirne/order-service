package com.carlobeirne.OrderService.features.address.models;


import com.carlobeirne.OrderService.features.customer.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @EqualsAndHashCode.Include
    @Column(name = "address_line1", length = 70, nullable = false)
    private String addressLine1;

    @EqualsAndHashCode.Include
    @Column(name = "address_line2", length = 70)
    private String addressLine2;

    @EqualsAndHashCode.Include
    @Column(name = "address_line3", length = 70)
    private String addressLine3;

    @EqualsAndHashCode.Include
    @Column(name = "city", length = 60, nullable = false)
    private String city;

    @EqualsAndHashCode.Include
    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @EqualsAndHashCode.Include
    @Column(name = "country", nullable = false)
    private String country;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> customers;

}
