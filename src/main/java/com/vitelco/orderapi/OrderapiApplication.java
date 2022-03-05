package com.vitelco.orderapi;

import com.vitelco.orderapi.model.Customer;
import com.vitelco.orderapi.model.Order;
import com.vitelco.orderapi.model.OrderItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class OrderapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderapiApplication.class, args);

		/*Customer customer = new Customer(1,"Fatos","Yorulmaz","ftmyrlmz@gmail.com");

		OrderItem item1 = new OrderItem(1,"su",5,20);
		OrderItem item2 = new OrderItem(2,"cola",2,15);

		Set<OrderItem> items = new HashSet<>();
		items.add(item1);
		items.add(item2);

		Order order = new Order(1,customer,items);


		log.info("Musteri: {} - siparisi : {}",customer,order); */
	}

}
