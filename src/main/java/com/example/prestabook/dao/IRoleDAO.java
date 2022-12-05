package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Role;


public interface IRoleDAO extends JpaRepository<Role, Long>{
	
	
}
