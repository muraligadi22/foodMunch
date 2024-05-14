package com.ctsdms.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctsdms.project.Service.OrderService;

@SpringBootTest
class OrderTest {
	
	@Autowired
	OrderService s;

	@Test
	void OrderNotNullTest() {
		assertNotNull(s.findallorders());
	}
	@Test
	void matchingCustomerIdBasedOnOrderTest() {
		assertEquals(111l,s.findUserById(111l).get(0).getCustomer().getCustomer_id());
	}
	@Test
	void orderExistByCustomerId(){
		assertNotNull(s.findUserById(111l));
	}

}
