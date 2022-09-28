package com.clarivate.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.FoodProduct;

public interface FoodProductRepo extends JpaRepository<FoodProduct, Integer>{

}
