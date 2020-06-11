package com.example.lworder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lworder.model.Order;
import com.example.lworder.service.OrderService;

@RestController
@RequestMapping("/placeOrder")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder/Order")
	public ResponseEntity<Order> addOrder(@RequestBody Order order  ) {
		Order orderObtained = orderService.addOrder(order);
		if (orderObtained.getId()!=null) {
			return new ResponseEntity<Order>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		}
	}


}
