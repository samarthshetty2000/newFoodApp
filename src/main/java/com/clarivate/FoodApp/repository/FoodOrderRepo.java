package com.clarivate.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{

}
