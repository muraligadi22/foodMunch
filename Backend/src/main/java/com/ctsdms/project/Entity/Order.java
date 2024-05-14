package com.ctsdms.project.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
@SequenceGenerator(name="id", sequenceName="id" , initialValue = 10)
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="id")
	private Long order_id;
	
	@Column
	private Long quantity;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column
	private Double totalprice;
	
//	@ManyToOne
//	@JoinColumn(name="food")
//	private Food food;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<OrderItem> orderItem;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	@Column 
	private String order_status;
	
	@Column
	private String tracking_id;
	
	@Column
	@CreationTimestamp
	private LocalDateTime orderdateandtime;
	
	
	
	public LocalDateTime getOrderdateandtime() {
		return orderdateandtime;
	}

	public void setOrderdateandtime(LocalDateTime orderdateandtime) {
		this.orderdateandtime = orderdateandtime;
	}

	public String getTracking_id() {
		return tracking_id;
	}

	public void setTracking_id(String tracking_id) {
		this.tracking_id = tracking_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Order(Long quantity) {
		super();
		this.quantity = quantity;
	}

	public Order() {
		
	}
	

}
