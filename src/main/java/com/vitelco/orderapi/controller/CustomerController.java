package com.vitelco.orderapi.controller;

import com.vitelco.orderapi.exception.NotFoundException;
import com.vitelco.orderapi.model.Customer;
import com.vitelco.orderapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    @ResponseBody
    public List<Customer> findAll(){
       /* Customer customer1 = new Customer(1,"Fatos","Yorulmaz","ftmyrlmz94@gmail.com");
        Customer customer2 = new Customer(2,"Yagmur","Gider","yagmur@gmail.com");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        return customers;*/

        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return customerService.findById(id).orElseThrow(NotFoundException::new);
    }

    @GetMapping("/email/{email}")
    public Customer findByEmail(@PathVariable String email){
        return customerService.findByEmail(email).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.save(customer);

    }
}
