package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.OrderItem;
import com.ctsdms.project.Service.OrderItemService;

@RestController
@RequestMapping("/api")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/orderitems")
	public List<OrderItem> findAllOrderItems() {
		return orderItemService.findAllOrderItems();
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/orderitems/{orderitemId}")
	public OrderItem findAllOrderItems(@PathVariable Long orderitemId) {
		return orderItemService.findById(orderitemId);
	}
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/orderitems/{orderitemId}")
	public void deleteOrderItemById(@PathVariable Long orderitemId) {
		orderItemService.deleteOrderItemById(orderitemId);
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/orderitemsbyorderid/{orderId}")
	public List<OrderItem> findAllOI(@PathVariable Long orderId) {
		return orderItemService.findByOrderId(orderId);
	}
	 
}
