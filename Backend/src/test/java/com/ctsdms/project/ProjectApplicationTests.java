package com.ctsdms.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctsdms.project.Service.CustomerService;

@SpringBootTest
class ProjectApplicationTests {
	
	@Autowired
	CustomerService s;

	@Test
	void contextLoads() {
		assertNotNull(s.FindAllCustomers());
	}

}
