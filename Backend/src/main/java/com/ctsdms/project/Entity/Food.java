package com.ctsdms.project.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="id", sequenceName="id" , initialValue = 10)
public class Food {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="id")
	private Long food_id;
	
	@Column
	private String food_name;
	
	@Column
	private Long quantity;
	
	@Column
	private Double price;
	
//	@OneToMany(mappedBy="food",cascade=CascadeType.ALL)
//	private List<Order> orders; 
	
	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItem;
	
	public Long getFood_id() {
		return food_id;
	}

	public void setFood_id(Long food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
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

	
	public Food(List<OrderItem> orderItem) {
		super();
		this.orderItem = orderItem;
	}

	public Food(String food_name, Long quantity, Double price) {
		super();
		this.food_name = food_name;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Food()
	{
		
	}

	
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_name=" + food_name + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	

}
