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

import com.example.prestabook.dto.Wrote;
import com.example.prestabook.service.WroteServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorWrote {
	
	@Autowired
	WroteServiceImpl wroteServiceImpl;
	
	@GetMapping("/wrote")
	public List<Wrote> listarWrotes(){
		return wroteServiceImpl.listarWrotes();
	}
	
	@PostMapping("/wrote")
	public Wrote crearWrote(@RequestBody Wrote wrote) {
		return wroteServiceImpl.crearWrote(wrote);
	}
	
	@GetMapping("/wrote/{id}")
	public Wrote leerWrote(@PathVariable(name="id") Long id) {
		
		Wrote wrote= new Wrote();
		
		wrote=wroteServiceImpl.leerWrote(id);
		
		System.out.println("Wrote segun ID: "+wrote);
		
		return wrote;
	}
	
	@PutMapping("/wrote/{id}")
	public Wrote actualizarWrote(@PathVariable(name="id")Long id,@RequestBody Wrote wrote) {
		
		Wrote wrote_seleccionado= new Wrote();
		Wrote wrote_actualizado= new Wrote();
		
		wrote_seleccionado= wroteServiceImpl.leerWrote(id);

		wrote_seleccionado.setId_author(wrote.getId_author());
		wrote_seleccionado.setId_book(wrote.getId_book());
		
		wrote_actualizado = wroteServiceImpl.actualizarWrote(wrote_seleccionado);
		
		System.out.println("El wrote actualizado es: "+ wrote_actualizado);
		
		return wrote_actualizado;
	}
	
	@DeleteMapping("/wrote/{id}")
	public void borrarWrote(@PathVariable(name="id")Long id) {
		wroteServiceImpl.borrarWrote(id);
	}
	
	
}
