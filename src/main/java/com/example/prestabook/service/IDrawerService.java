package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Drawer;

public interface IDrawerService {

	//Metodos del CRUD
	
	public List<Drawer> listarDrawers(); //Listar All 
	
	public Drawer crearDrawer(Drawer drawer);	//CREATE
	
	public Drawer leerDrawer(String id); // READ
		
	public Drawer actualizarDrawer(Drawer drawer); // UPDATE
	
	public void borrarDrawer(String id);// DELETE
	
	
}
