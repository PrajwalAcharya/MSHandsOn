package com.example.OrderMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderMicroservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
