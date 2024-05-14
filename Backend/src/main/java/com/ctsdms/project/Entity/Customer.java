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
public class Customer{
	//private static final GenerationType  = null;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="id")
	private Long customer_id;
	
	@Column
	private String name;
	
	
	@Column
	private Long phone_no;
	
	@Column
	private String Address;
	
	@Column(unique = true)
	private String email;
	

	@Column
	private String password;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Customer(String email,String password,String name, Long phone_no, String address) {
		super();
		this.email=email;
		this.password=password;
		this.name = name;
		this.phone_no = phone_no;
		Address = address;
	}
	
	public Customer() {
		
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", phone_no=" + phone_no + ", Address="
				+ Address + "]";
	}


	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
	

}
