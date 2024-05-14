package com.ctsdms.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctsdms.project.Entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {

}
