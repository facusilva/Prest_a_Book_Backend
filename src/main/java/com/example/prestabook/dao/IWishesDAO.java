package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Wishes;


public interface IWishesDAO extends JpaRepository<Wishes, Long>{
	
	
}
