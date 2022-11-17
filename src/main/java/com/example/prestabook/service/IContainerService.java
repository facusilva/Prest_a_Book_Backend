package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Container;

public interface IContainerService {

	//Metodos del CRUD
	
	public List<Container> listarContainers(); //Listar All 
	
	public Container crearContainer(Container container);	//CREATE
	
	public Container leerContainer(Long id); // READ
		
	public Container actualizarContainer(Container container); // UPDATE
	
	public void borrarContainer(Long id);// DELETE
	
	
}
