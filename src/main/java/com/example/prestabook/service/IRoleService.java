package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Role;

public interface IRoleService {

	//Métodos del CRUD
	
	public List<Role> listarRoles(); //Listar All
	
	public Role crearRole(Role Role); //Guarda un Role CREATE
	
	public Role leerRole(Long id);//buscar libro por su id
	
	public Role actualizarRole(Role Role); //Actualiza datos del Role UPDATE
	
	public void borrarRole(Long id);//Elimina el Role DELETE
}
