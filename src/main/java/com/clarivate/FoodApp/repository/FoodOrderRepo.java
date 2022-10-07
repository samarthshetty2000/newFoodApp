package com.clarivate.FoodApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{
	
	List<FoodOrder> findByuser_id(int id);

}
