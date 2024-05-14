package com.ctsdms.project.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="id", sequenceName="id" , initialValue = 1)
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  Long cart_id;
	
	@Column
	private Long quantity;
	
	@Column 
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="food_id")
	private Food food;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart(Long quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
	
	public Cart() {
		
	}
	
	

}
