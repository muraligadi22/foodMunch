package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Order;

public interface OrderService {
	
	Order addOrder(Order order);
	List<Order> findallorders();
	Order findorderbyid(Long id);
	void deleteorderbyid(Long id);
	Order updateCustomer(Order order);
	public List<Order> findUserById(Long customer_id);

}
