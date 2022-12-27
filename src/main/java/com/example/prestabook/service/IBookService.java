package com.example.prestabook.service;

import java.util.List;


import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Usuario;

public interface IBookService {

	//Métodos del CRUD
	
	public List<Book> listarBooks(); //Listar All
	
	public Book crearBook(Book Book); //Guarda un Book CREATE
	
	public Book leerBook(Long id);//buscar libro por su id
	
	public Book actualizarBook(Book Book); //Actualiza datos del Book UPDATE
	
	public void borrarBook(Long id);//Elimina el Book DELETE
	
	public List<Book> leerBookByUser(Usuario usuario);
}
