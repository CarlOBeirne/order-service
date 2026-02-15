package com.carlobeirne.OrderService.features.customer.controllers;

import com.carlobeirne.OrderService.features.customer.mapper.CustomerMapper;
import com.carlobeirne.OrderService.features.customer.models.Customer;
import com.carlobeirne.OrderService.features.customer.models.CustomerDto;
import com.carlobeirne.OrderService.features.customer.services.CustomerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDataService customerDataService;
    private final CustomerMapper customerMapper;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerDataService.findAllCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> createNewCustomer(@RequestBody CustomerDto customerDto) {
        Customer entity = customerMapper.toEntity(customerDto);
        Customer save = customerDataService.save(entity);
        return ResponseEntity.ok(save);
    }
}
