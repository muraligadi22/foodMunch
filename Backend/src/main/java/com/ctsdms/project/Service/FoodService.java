package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Food;

public interface FoodService {
	
	Food addFood(Food food);
	List<Food> getAllFood();
	void deleteFood(Long id);
	Food getbyid(Long id);
	Food updateFood(Food food);
	

}
