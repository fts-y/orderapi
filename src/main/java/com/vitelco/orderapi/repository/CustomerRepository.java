package com.vitelco.orderapi.repository;

import com.vitelco.orderapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    Optional<Customer> findByEmail(String email);
}