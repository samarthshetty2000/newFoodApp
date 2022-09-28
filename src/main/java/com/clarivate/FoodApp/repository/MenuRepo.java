package com.clarivate.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

}
