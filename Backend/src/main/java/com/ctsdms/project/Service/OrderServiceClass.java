package com.ctsdms.project.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdms.project.CustomeException.CustomerNotFoundException;
//import com.ctsdms.project.CustomeException.StudentNotFoundException;
import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Entity.Food;
import com.ctsdms.project.Entity.Order;
import com.ctsdms.project.Entity.OrderItem;
import com.ctsdms.project.Repository.CartRepository;
import com.ctsdms.project.Repository.CustomerRepository;
import com.ctsdms.project.Repository.FoodRepository;
import com.ctsdms.project.Repository.OrderItemRepository;
import com.ctsdms.project.Repository.OrderRepository;

@Service
public class OrderServiceClass implements OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	FoodRepository repo1;
	
	@Autowired
	OrderService service;
	
	@Autowired
	FoodService service1;
	
	@Autowired
	CartRepository cartrepo;
	@Autowired
	OrderItemRepository oirepo;
	
	@Autowired
	CustomerRepository custrepo;
	
	@Override
	public Order addOrder(Order order) {
		List<Cart> cartitems=cartrepo.findUserById(order.getCustomer().getCustomer_id());
		Double price=0.0;
		Long custquantity=0L;
		for(Cart ci: cartitems) {
			Food food=repo1.findById(ci.getFood().getFood_id()).get();
			
			if(!(food.getQuantity()<ci.getQuantity())) {
				price+=ci.getPrice()*ci.getQuantity();
				custquantity+=ci.getQuantity();
				food.setQuantity(food.getQuantity()-ci.getQuantity());
				repo1.save(food);
				//cartrepo.delete(ci);
			}
			
		}
		if(custquantity==0 || price==0)
		order.setOrder_status("order unplaced");
		else {
		order.setOrder_status("order placed");
		order.setQuantity(custquantity);
		order.setTotalprice(price);
		order.setTracking_id("FM"+(int)(Math.random()*10000000));
		order.setCustomer(custrepo.findById(order.getCustomer().getCustomer_id()).get());
		Order orderplaced=repo.save(order);
		for(Cart ci: cartitems) {
			OrderItem oi=new OrderItem(ci.getQuantity(),ci.getPrice()*ci.getQuantity(),orderplaced,ci.getFood());
			oirepo.save(oi);
			cartrepo.delete(ci);
		}
		return orderplaced;
		}
		return null;
	}
	@Override
	public List<Order> findallorders() {
		List<Order> orders=repo.findAll();
		return orders;
	}

	@Override
	public Order findorderbyid(Long id) {
	try {
		return repo.findById(id).get();
	}
	catch(Exception e){
		throw new CustomerNotFoundException("No order found!!");
	}		
}
	@Override
	public void deleteorderbyid(Long id) {
		// TODO Auto-generated method stub
//		Optional<Order> order=repo.findById(id);
//		Order orderr=order.get();
//		repo.delete(orderr);	
		List<OrderItem> oitems=oirepo.findByOrderId(id);
		for(OrderItem oi:oitems) {
			Food food=service1.getbyid(oi.getFood().getFood_id());
			food.setQuantity(food.getQuantity()+oi.getQuantity());
			repo1.save(food);
			//oirepo.deleteOrderItemByOrderId(oi.getOrder_itemId());
		}
		repo.deleteById(id);
	}

	@Override
	public Order updateCustomer(Order order) {
			Order c=repo.saveAndFlush(order);
			return c;
	}
	@Override
	public List<Order> findUserById(Long customer_id) {
		// TODO Auto-generated method stub
		return repo.findUserById(customer_id);
	}

}
