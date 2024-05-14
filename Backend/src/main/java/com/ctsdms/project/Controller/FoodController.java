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

import com.ctsdms.project.Entity.Food;
import com.ctsdms.project.Service.FoodService;

@RestController
@RequestMapping("/dining/food")
public class FoodController {
	
	@Autowired
	FoodService service;
	
	
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/add")
	public Food addFood(@RequestBody Food food) {
		Food f=service.addFood(food);
		return f;
	}
	
	@CrossOrigin("http://localhost:4200/")
	@PutMapping("/update")
	public Food updateFood(@RequestBody Food food) {
		Food f=service.addFood(food);
		return f;
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getall")
	public List<Food> getallfoods(){
		List<Food> foods=service.getAllFood();
		return foods;
	}
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/getbyid/{food_id}")
	public Food getbyid(@PathVariable Long food_id) {
		Food f=service.getbyid(food_id);
		return f;
	}
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/delete/{food_id}")
	public void deletefood(@PathVariable Long food_id){
		service.deleteFood(food_id);
	}

}
