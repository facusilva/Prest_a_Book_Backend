package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Container;


public interface IContainerDAO extends JpaRepository<Container, Long>{
	
	
}
