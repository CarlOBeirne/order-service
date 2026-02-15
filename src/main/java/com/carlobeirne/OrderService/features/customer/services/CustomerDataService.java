package com.carlobeirne.OrderService.features.customer.services;

import com.carlobeirne.OrderService.features.customer.models.Customer;
import com.carlobeirne.OrderService.features.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomerDataService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }
}
