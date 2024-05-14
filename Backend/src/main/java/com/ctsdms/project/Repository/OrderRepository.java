package com.ctsdms.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.Cart;
import com.ctsdms.project.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

	@Query(value="select * from orders where customer= :customer",nativeQuery=true)
	List<Order> findUserById(Long customer);
	
}
