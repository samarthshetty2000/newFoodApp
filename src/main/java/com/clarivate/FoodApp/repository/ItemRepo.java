package com.clarivate.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
