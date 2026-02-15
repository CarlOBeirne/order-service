package com.carlobeirne.OrderService.features.customer.repositories;

import com.carlobeirne.OrderService.features.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
