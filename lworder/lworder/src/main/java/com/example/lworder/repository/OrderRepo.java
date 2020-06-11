package com.example.lworder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lworder.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>{

}
