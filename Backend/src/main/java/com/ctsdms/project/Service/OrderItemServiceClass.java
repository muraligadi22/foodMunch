package com.ctsdms.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.Entity.OrderItem;
import com.ctsdms.project.Repository.OrderItemRepository;

@Service
public class OrderItemServiceClass implements OrderItemService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public List<OrderItem> findAllOrderItems() {
		// TODO Auto-generated method stub
		return orderItemRepository.findAll();
	}

	@Override
	public OrderItem findById(Long id) {
		// TODO Auto-generated method stub
		return orderItemRepository.findById(id).get();
	}

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemRepository.save(orderItem);
	}

	@Override
	public void deleteOrderItemById(Long id) {
		// TODO Auto-generated method stub
		orderItemRepository.deleteById(id);
	}
	
	 public List<OrderItem> findByOrderId(Long orderId){
		 return orderItemRepository. findByOrderId(orderId);
	 }
	 
	
}
