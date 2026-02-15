package com.carlobeirne.OrderService.features.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String emailAddress;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Long mobileNo;
}
