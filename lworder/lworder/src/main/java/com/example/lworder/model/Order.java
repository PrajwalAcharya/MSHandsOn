package com.example.lworder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemorder")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="OrderName")
	private String orderName;
	
	@Column(name="OrderPrice")
	private Double orderPrice;
	
	@Column(name="AccessToken")
	private String accessToken;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, String orderName, Double orderPrice, String accessToken) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.accessToken = accessToken;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	


}
