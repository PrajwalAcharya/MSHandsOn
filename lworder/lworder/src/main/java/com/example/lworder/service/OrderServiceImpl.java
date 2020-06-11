package com.example.lworder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lworder.model.Order;
import com.example.lworder.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo orderRepo;
	
	public Order addOrder(Order order) {
		
		orderRepo.save(order);
		return order;
	}
	
	

}
