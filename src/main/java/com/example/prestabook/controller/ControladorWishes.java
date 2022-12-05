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

import com.example.prestabook.dto.Wishes;
import com.example.prestabook.service.WishesServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorWishes {
	
	@Autowired
	WishesServiceImpl wishesServiceImpl;
	
	@GetMapping("/wishes")
	public List<Wishes> listarWishes(){
		return wishesServiceImpl.listarWishes();
	}
	
	@PostMapping("/wishes")
	public Wishes crearWishes(@RequestBody Wishes wishes) {
		
		return wishesServiceImpl.crearWishes(wishes);
		
	}
	
	
	@GetMapping("/wishes/{id}")
	public Wishes leerWishes(@PathVariable(name="id") Long id) {
		
		Wishes wishes= new Wishes();
		
		wishes=wishesServiceImpl.leerWishes(id);
		
		System.out.println("Wishes segun ID: "+wishes);
		
		return wishes;
	}
	
	@PutMapping("/wishes/{id}")
	public Wishes actualizarWishes(@PathVariable(name="id")Long id,@RequestBody Wishes wishes) {
		
		Wishes wishes_seleccionado= new Wishes();
		Wishes wishes_actualizado= new Wishes();
		
		wishes_seleccionado= wishesServiceImpl.leerWishes(id);

		wishes_seleccionado.setId_user(wishes.getId_user());
		wishes_seleccionado.setId_book(wishes.getId_book());

		
		wishes_actualizado = wishesServiceImpl.actualizarWishes(wishes_seleccionado);
		
		System.out.println("El wishes actualizado es: "+ wishes_actualizado);
		
		return wishes_actualizado;
	}
	
	@DeleteMapping("/wishes/{id}")
	public void borrarWishes(@PathVariable(name="id")Long id) {
		wishesServiceImpl.borrarWishes(id);
	}
	
	
}
