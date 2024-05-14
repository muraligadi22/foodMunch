package com.ctsdms.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Service.CartService;

@RestController
@RequestMapping("/dining/cart")
public class CartController {
	
	@Autowired 
	CartService service;
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/add")
	public Cart addcart(@RequestBody Cart cart) {
		return service.addcart(cart);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getall")
	public List<Cart> getall(){
		return service.getallcarts();
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getuserbyid/{customer_id}")
	public List<Cart> getitemsbyid(@PathVariable Long customer_id){
		return service.findUserById(customer_id);
	}
	
	@GetMapping("/getbyid")
	public Cart getbyid(Long id) {
		return service.getcartbyid(id);
	}
	@CrossOrigin("http://localhost:4200/")
	@PutMapping("/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return service.updateCart(cart);
	}
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/delete/{cart_id}")
	public void deletecart(@PathVariable Long cart_id) {
		service.deletebyid(cart_id);
	}

}
