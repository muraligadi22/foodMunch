package com.ctsdms.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.Customer;
import com.ctsdms.project.Entity.Order;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	@Query(value = "select count(s.customer_id) from customer s",nativeQuery=true)
	Long countofentries();
	
	@Query(value="select * from customer where email= :email and password=:password",nativeQuery=true)
	Customer findUserByCredentials(String email,String password);

}
