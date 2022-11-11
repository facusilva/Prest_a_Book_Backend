package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Editorial;

public interface IEditorialService {

	//Metodos del CRUD
	
	public List<Editorial> listarEditoriales(); //Listar All 
	
	public Editorial crearEditorial(Editorial editorial);	//CREATE
	
	public Editorial leerEditorial(Long id); // READ
		
	public Editorial actualizarEditorial(Editorial editorial); // UPDATE
	
	public void borrarEditorial(Long id);// DELETE
	
	
}
