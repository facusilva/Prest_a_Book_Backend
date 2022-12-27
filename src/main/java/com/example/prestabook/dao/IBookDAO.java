package com.example.prestabook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Usuario;
import com.example.prestabook.dto.Book;

public interface IBookDAO extends JpaRepository<Book, Long>{

	Book findByTitle(String title);
	Book findByIsbn(String isbn);
	List<Book> findByUsuario(Usuario usuario);
}
