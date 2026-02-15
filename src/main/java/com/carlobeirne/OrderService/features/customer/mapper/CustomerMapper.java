package com.carlobeirne.OrderService.features.customer.mapper;

import com.carlobeirne.OrderService.features.customer.models.Customer;
import com.carlobeirne.OrderService.features.customer.models.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    Customer toEntity(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);

}
