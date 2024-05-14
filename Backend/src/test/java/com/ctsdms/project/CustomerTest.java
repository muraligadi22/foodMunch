package com.ctsdms.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctsdms.project.Repository.CustomerRepository;
import com.ctsdms.project.Service.CustomerService;

@SpringBootTest
class CustomerTest {
	
	@Autowired
	CustomerService s;
	@Autowired
	CustomerRepository repo;

	@Test
	void customerListNotNull() {
		assertNotNull(s.FindAllCustomers());
	}
	@Test
	void customerByIdTest() {
		assertNotNull(s.findCustomerById(111l));
	}
	@Test
	void customerCountTest() {
		assertEquals(10, repo.countofentries());
	}
	
	@Test
	void customerComparisionTest() {
		assertNotEquals(s.findCustomerById(111l),s.findCustomerById(311l));
	}
	
}
