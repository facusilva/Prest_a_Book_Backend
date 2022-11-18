package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Usuario;

public interface IUserService {

	//Metodos del CRUD
	
	public List<Usuario> listarUsers(); //Listar All 
	
	public Usuario crearUser(Usuario user);	//CREATE
	
	public Usuario leerUser(Long id); // READ
		
	public Usuario actualizarUser(Usuario user); // UPDATE
	
	public void borrarUser(Long id);// DELETE
	
	
}