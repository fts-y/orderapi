package com.vitelco.orderapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "orderitems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem  {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name ="orderid")
    private Order order;
    private String title;
    private int qty;
    private int price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "productid")
    private Product product;



    public OrderItem(long id,String title, int qty, int price) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
    }


}

