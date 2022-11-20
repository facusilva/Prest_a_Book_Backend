package com.example.prestabook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prestabook.dto.Editorial;
import com.example.prestabook.service.EditorialServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorEditorial {
	
	@Autowired
	EditorialServiceImpl editorialServiceImpl;
	
	@GetMapping("/editorials")
	public List<Editorial> listarEditoriales(){
		return editorialServiceImpl.listarEditoriales();
	}
	
	@PostMapping("/editorials")
	public Editorial crearEditorial(@RequestBody Editorial editorial) {
		
		return editorialServiceImpl.crearEditorial(editorial);
		
	}
	
	
	@GetMapping("/editorials/{id}")
	public Editorial leerEditorial(@PathVariable(name="id") Long id) {
		
		Editorial editorial= new Editorial();
		
		editorial=editorialServiceImpl.leerEditorial(id);
		
		System.out.println("Editorial segun ID: "+editorial);
		
		return editorial;
	}
	
	@PutMapping("/editorials/{id}")
	public Editorial actualizarEditorial(@PathVariable(name="id")Long id,@RequestBody Editorial editorial) {
		
		Editorial editorial_seleccionado= new Editorial();
		Editorial editorial_actualizado= new Editorial();
		
		editorial_seleccionado= editorialServiceImpl.leerEditorial(id);

		editorial_seleccionado.setEditorial_name(editorial.getEditorial_name());
		editorial_seleccionado.setCountry(editorial.getCountry());
		editorial_seleccionado.setId_user(editorial.getId_user());

		
		editorial_actualizado = editorialServiceImpl.actualizarEditorial(editorial_seleccionado);
		
		System.out.println("El editorial actualizado es: "+ editorial_actualizado);
		
		return editorial_actualizado;
	}
	
	@DeleteMapping("/editorials/{id}")
	public void borrarEditorial(@PathVariable(name="id")Long id) {
		editorialServiceImpl.borrarEditorial(id);
	}
	
	
}
