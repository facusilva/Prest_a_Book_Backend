package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.User;


public interface IUserDAO extends JpaRepository<User, Long>{
	
}
