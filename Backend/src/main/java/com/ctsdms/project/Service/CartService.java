package com.ctsdms.project.Service;

import java.util.List;

import com.ctsdms.project.Entity.Cart;

public interface CartService {
	
	Cart getcartbyid(Long id);
	List<Cart> getallcarts();
	void deletebyid(Long id);
	Cart updateCart(Cart cart);
	Cart addcart(Cart cart);
	List<Cart> findUserById(Long customer_id);
	
}
