package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IBookDAO;
import com.example.prestabook.dto.Book;

@Service
public class BookServiceImpl implements IBookService{
	
	//Utilizamos los metodos de la interface IBookDAO, es como si instanciaramos.
	@Autowired
	IBookDAO iBookDAO;
	
	@Override
	public List<Book> listarBooks() {
		return iBookDAO.findAll();
	}
	
	@Override
	public Book crearBook(Book book) {
		return iBookDAO.save(book);
	}

	@Override
	public Book leerBook(Long id) {
		return iBookDAO.findById(id).get();
	}

	@Override
	public Book actualizarBook(Book book) {
		return iBookDAO.save(book);
	}

	@Override
	public void borrarBook(Long id) {
		iBookDAO.deleteById(id);
	}

}
