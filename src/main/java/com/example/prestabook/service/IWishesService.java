package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Usuario;
import com.example.prestabook.dto.Wishes;

public interface IWishesService {

	//Metodos del CRUD
	
	public List<Wishes> listarWishes(); //Listar All 
	
	public Wishes crearWishes(Wishes wishes);	//CREATE
	
	public Wishes leerWishes(Long id); // READ
		
	public Wishes actualizarWishes(Wishes wishes); // UPDATE
	
	public void borrarWishes(Long id);// DELETE
	
	public List<Wishes> leerBookByUser(Usuario usuario);
	
	public Wishes leerWishByUserBook(Usuario usuario, Book book);
}
