package com.ctsdms.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.CustomeException.CustomerNotFoundException;
//import com.ctsdms.project.CustomeException.StudentNotFoundException;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Entity.Food;
import com.ctsdms.project.Repository.FoodRepository;

@Service
public class FoodServiceClass implements FoodService {
	
	@Autowired
	FoodRepository repo;

	@Override
	public Food addFood(Food food) {
		// TODO Auto-generated method stub
		Food  f=repo.save(food);
		return f;
	}

	@Override
	public List<Food> getAllFood() {
		// TODO Auto-generated method stub
		List<Food> foods=repo.findAll();
		return foods;
	}

	@Override
	public void deleteFood(Long id) {
		repo.delete(repo.findById(id).get());
		
	}

	@Override
	public Food getbyid(Long id) {
		try {
		return repo.findById(id).get();
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("No Food Found!!");
		}
	}
	@Override
	public Food updateFood(Food food) {
			Food c=repo.saveAndFlush(food);
			return c;
	}

}
