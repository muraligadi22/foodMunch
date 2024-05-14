package com.ctsdms.project.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long admin_id;
	
	@Column
	private String email;
	
	
	@Column
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String email,String password) {
		super();
		this.email=email;
		this.password = password;
	}
	public Admin() {
		
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", password=" + password + "]";
	}
		
	}


