package com.vitelco.orderapi.service;

import com.vitelco.orderapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Long id);

}
