package com.vitelco.orderapi.service;

import com.vitelco.orderapi.model.Customer;
import com.vitelco.orderapi.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    boolean login(Customer customer);

    List<Customer> findAll();

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);


    Optional<Customer> findByEmail(String email);
}
