package com.vitelco.orderapi.controller;

import com.vitelco.orderapi.exception.NotFoundException;
import com.vitelco.orderapi.model.Product;
import com.vitelco.orderapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @ResponseBody
    public List<Product> findAll(){
        return productService.findAll();

    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(NotFoundException::new);
        /*Product product = new Product(1,"su");
        return product;*/
    }

    @PostMapping
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);

    }
}
