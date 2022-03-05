package com.vitelco.orderapi.controller;

import com.vitelco.orderapi.exception.NotFoundException;
import com.vitelco.orderapi.model.Customer;
import com.vitelco.orderapi.model.Order;
import com.vitelco.orderapi.model.OrderItem;
import com.vitelco.orderapi.service.CustomerService;
import com.vitelco.orderapi.service.OrderItemService;
import com.vitelco.orderapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    private final OrderItemService orderItemService;
    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService, ProductService productService, CustomerService customerService) {
        this.orderItemService = orderItemService;
        this.productService = productService;
        this.customerService = customerService;
    }


    @GetMapping
    @ResponseBody
    public List<OrderItem> findAll(){
        return orderItemService.findAll();

    }

    @GetMapping("/{id}")
    public OrderItem findById(@PathVariable Long id){
        return orderItemService.findById(id).orElseThrow(NotFoundException::new);

    }

    @PostMapping
    @ResponseBody
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.save(orderItem);

    }
}
