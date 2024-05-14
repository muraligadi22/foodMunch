package com.ctsdms.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctsdms.project.Service.CartService;

@SpringBootTest
class CartTest {
	
	@Autowired
	CartService s;

	@Test
	void foodListNotNull() {
		assertEquals(1,s.getallcarts().size());
	}
	@Test
	void testCartItemsByDiffCustomerIds() {
		assertEquals(111L,s.findUserById(111l).get(0).getCustomer().getCustomer_id());
	}
}
