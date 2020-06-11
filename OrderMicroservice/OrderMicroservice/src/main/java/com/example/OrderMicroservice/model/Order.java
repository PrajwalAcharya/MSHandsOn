package com.example.OrderMicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Price")
	private Double price;
	
	@Column(name="AccessToken")
	private String accessToken;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String name, Double price, String accessToken) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.accessToken = accessToken;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	
}
