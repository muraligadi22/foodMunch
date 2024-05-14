package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Order;
import com.ctsdms.project.Repository.OrderRepository;
import com.ctsdms.project.Service.OrderService;

@RestController
@RequestMapping("/dining/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	@Autowired
	OrderRepository orepo;
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/add")
	public Order addorder(@RequestBody Order order) {
		Order o=service.addOrder(order);
		return o;
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getall")
	public List<Order> getallorders(){
		List<Order> l=service.findallorders();
		return l;
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getbyid/{order_id}")
	public Order getbyid(@PathVariable Long order_id) {
		Order o=service.findorderbyid(order_id);
		return o;
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getbyuserid/{customer}")
	public List<Order> findById(@PathVariable Long customer) {
	
		return service.findUserById(customer);
	}
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/delete/{order_id}")
	public void deletebyid(@PathVariable Long order_id) {
		service.deleteorderbyid(order_id);
	}
}
