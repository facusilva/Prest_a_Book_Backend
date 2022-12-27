package com.example.prestabook.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Wrote;


public interface IWroteDAO extends JpaRepository<Wrote, Long>{
	
	Wrote findByBook(Book book);
}
