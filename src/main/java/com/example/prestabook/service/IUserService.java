package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.User;

public interface IUserService {

	//Metodos del CRUD
	
	public List<User> listarUsers(); //Listar All 
	
	public User crearUser(User user);	//CREATE
	
	public User leerUser(Long id); // READ
		
	public User actualizarUser(User user); // UPDATE
	
	public void borrarUser(Long id);// DELETE
	
	
}