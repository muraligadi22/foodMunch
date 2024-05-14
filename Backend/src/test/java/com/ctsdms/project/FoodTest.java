package com.ctsdms.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ctsdms.project.Repository.FoodRepository;
import com.ctsdms.project.Service.FoodService;

@SpringBootTest
class FoodTest {
	
	@Autowired
	FoodService s;
	@Autowired
	FoodRepository repo;

	@Test
	void foodListNotNull() {
		assertNotNull(s.getAllFood());
	}
	@Test
	void foodByIdTest() {
		assertNotNull(s.getbyid(661l));
	}
	@Test
	void foodCountTest() {
		assertEquals(3, repo.count());
	}
	
	@Test
	void foodComparision() {
		assertNotEquals(s.getbyid(661l),s.getbyid(12l));

}
}
