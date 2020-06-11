package com.example.OrderMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.OrderMicroservice.model.Order;
import com.example.OrderMicroservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	
	
	public Order addOrder(Order order) {
		
		orderRepository.save(order);
		return order;
		
	}
	

}
