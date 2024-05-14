package com.ctsdms.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	
	@Query(value="select id from order_item",nativeQuery=true)
	List<Long> findAllOrderItemsIds();
	
	@Query(value = "select * from order_item where order_id = :orderId",nativeQuery=true)
	List<OrderItem> findByOrderId(Long orderId);
	
	@Query(value = "delete from order_item where order_id = :orderId",nativeQuery=true)
	void deleteOrderItemByOrderId(Long orderId);

}
