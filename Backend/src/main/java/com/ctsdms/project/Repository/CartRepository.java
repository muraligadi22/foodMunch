package com.ctsdms.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

	@Query(value="select * from cart where customer_id=?1",nativeQuery=true)
	List<Cart> findUserById(Long customer_id);
	
	@Query(value="select food_id from cart where customer_id=?1",nativeQuery=true)
	List<Long> findFoodIds(Long customer_id);
	
	@Query(value="select * from cart where food_id=?1",nativeQuery=true)
	Cart findCartByFoodId(Long food_id);
	

}
