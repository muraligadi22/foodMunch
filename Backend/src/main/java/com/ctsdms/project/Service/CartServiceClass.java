package com.ctsdms.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.CustomeException.CustomerNotFoundException;
import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Entity.Food;
import com.ctsdms.project.Repository.CartRepository;
import com.ctsdms.project.Repository.FoodRepository;

@Service
public class CartServiceClass implements CartService {

	@Autowired
	CartRepository repo;
	
	@Autowired
	FoodRepository repo1;
	
	@Override
	public Cart getcartbyid(Long id) {
		try {
		return repo.findById(id).get();
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("No Cart found!!");
		}
	}

	@Override
	public List<Cart> getallcarts() {
		return repo.findAll();
	}

	@Override
	public void deletebyid(Long id) {
		try {
		repo.delete(repo.findById(id).get());
		}
		catch(Exception e) {
			throw new CustomerNotFoundException("No cart Found, cant delete this");
		}
		
	}

	@Override
	public Cart updateCart(Cart cart) {
		return repo.save(cart);
	    
	}

	@Override
	public Cart addcart(Cart cart) {
		List<Long> foodIds= repo.findFoodIds(cart.getCustomer().getCustomer_id());
		Long l=cart.getFood().getFood_id();
		if(foodIds.contains(l)) {
			Cart cartitem=repo.findCartByFoodId(l);
			cartitem.setQuantity(cart.getQuantity());
			cart=cartitem;
		}
		else {
			Food f=repo1.findById(l).get();
			cart.setPrice( f.getPrice());
		}
		return repo.save(cart);
	}

	@Override
	public List<Cart> findUserById(Long customer_id) {
		// TODO Auto-generated method stub
		return repo.findUserById(customer_id);
	}

}
