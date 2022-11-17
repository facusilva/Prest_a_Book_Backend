package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Author;

public interface IAuthorService {

	//Metodos del CRUD
	
	public List<Author> listarAuthors(); //Listar All 
	
	public Author crearAuthor(Author user);	//CREATE
	
	public Author leerAuthor(Long id); // READ
		
	public Author actualizarAuthor(Author user); // UPDATE
	
	public void borrarAuthor(Long id);// DELETE
	
	
}