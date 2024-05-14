package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	List<Customer> FindAllCustomers();
	Customer findCustomerById(Long id);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(Long id);
	Customer findUserByCredentials(String email,String password);
}
