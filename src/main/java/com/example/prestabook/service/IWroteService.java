package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Wrote;

public interface IWroteService {

	//Metodos del CRUD
	
	public List<Wrote> listarWrotes(); //Listar All 
	
	public Wrote crearWrote(Wrote user);	//CREATE
	
	public Wrote leerWrote(Long id); // READ
		
	public Wrote actualizarWrote(Wrote user); // UPDATE
	
	public void borrarWrote(Long id);// DELETE
	
	
}