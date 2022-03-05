package com.vitelco.orderapi.controller;

import com.vitelco.orderapi.exception.NotFoundException;
import com.vitelco.orderapi.model.Customer;
import com.vitelco.orderapi.model.Order;
import com.vitelco.orderapi.model.OrderItem;
import com.vitelco.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    @ResponseBody
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id){
        return orderService.findById(id).orElseThrow(NotFoundException::new);
       /* Customer customer = new Customer(1,"Fatos","Yorulmaz","ftmyrlmz@gmail.com");
        OrderItem item1 = new OrderItem(1,"su",5,20);
        OrderItem item2 = new OrderItem(2,"cola",2,15);
        Set<OrderItem> items = new HashSet<>();
        items.add(item1);
        items.add(item2);
        Order order = new Order(1,customer,items);
        return  order;*/
    }

    @PostMapping
    @ResponseBody
    public Order createOrder(@RequestBody Order order){
        return orderService.save(order);

    }
}
