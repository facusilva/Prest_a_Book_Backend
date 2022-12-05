package com.example.prestabook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Book;

public interface IBookDAO extends JpaRepository<Book, Long>{

	//public Book findByIsbn(String isbn);

}
