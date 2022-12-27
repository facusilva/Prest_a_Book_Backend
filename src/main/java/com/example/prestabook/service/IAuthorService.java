package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Author;

public interface IAuthorService {

	//Metodos del CRUD
	
	public List<Author> listarAuthors(); //Listar All 
	
	public Author crearAuthor(Author author);	//CREATE
	
	public Author leerAuthor(Long id); // READ
		
	public Author actualizarAuthor(Author author); // UPDATE
	
	public void borrarAuthor(Long id);// DELETE
	
	
}