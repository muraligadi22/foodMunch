package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.OrderItem;

public interface OrderItemService {

	List<OrderItem> findAllOrderItems();
	OrderItem findById(Long id);
	OrderItem updateOrderItem(OrderItem orderItem);
	void deleteOrderItemById(Long id);
	List<OrderItem> findByOrderId(Long orderId);
}
