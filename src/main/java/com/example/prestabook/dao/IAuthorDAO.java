package com.example.prestabook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Author;

public interface IAuthorDAO extends JpaRepository<Author, Long>{
	
}
