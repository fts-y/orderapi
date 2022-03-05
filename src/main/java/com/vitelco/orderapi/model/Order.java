package com.vitelco.orderapi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime createdDate;
    private float amount;

    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;


    @OneToMany
    private Set<OrderItem> items;

    public Order(long id,Customer customer,Set<OrderItem> items) {
        this.id = id;
        this.createdDate = LocalDateTime.now();
        this.customer = customer;
        this.items = items;
        this.amount = this.calcTotal()
;
    }

    public float calcTotal() {
        if (this.getItems().size() == 0) {
            log.error("There is no order item");
            return 0f;
        }
        float total = 0f;
        for (OrderItem item: this.getItems()){
            total +=item.getPrice() * item.getQty();
        }

        return total;
    }

}

