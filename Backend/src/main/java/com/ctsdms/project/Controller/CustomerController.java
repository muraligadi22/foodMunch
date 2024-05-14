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
import com.ctsdms.project.DTO.UserCredentials;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Repository.CustomerRepository;
import com.ctsdms.project.Service.CustomerService;

@RestController
@RequestMapping("dining/customer")
@CrossOrigin("http://localhost:4200/")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	CustomerRepository crepo;
	
	@GetMapping("/count")
	public Long getcountofentries() {
		Long l=crepo.countofentries();
		return l;
	}
	@PostMapping("/add")
	public Customer addcustomer(@RequestBody Customer customer) {
		Customer cust=service.addCustomer(customer);
		return cust;
	}
	@GetMapping("/getall")
	public List<Customer> findallcustomers(){
		List<Customer> customers=service.FindAllCustomers();
		return customers;
	}
	@GetMapping("/getbyid/{customer_id}")
	public Customer findbyid(@PathVariable Long customer_id) {
		Customer c=service.findCustomerById(customer_id);
		return c;
	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer c=service.updateCustomer(customer);
		return c;
	}
	
	@DeleteMapping("/delete/{customer_id}")
	public void deletecustomer(@PathVariable Long customer_id) {
		service.deleteCustomer(customer_id);
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/login")
	public Customer loginCustomer(@RequestBody UserCredentials login) {
		return service.findUserByCredentials(login.getEmail(),login.getPassword());
	}
	
	
}
