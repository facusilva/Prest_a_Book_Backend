package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Editorial;


public interface IEditorialDAO extends JpaRepository<Editorial, Long>{
	
	Editorial findByName(String name);
}
