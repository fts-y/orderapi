package com.vitelco.orderapi.service;

import com.vitelco.orderapi.model.Order;


import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Order save (Order order);

    Optional<Order> findById(Long id);
}
