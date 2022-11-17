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

import com.example.prestabook.dto.Container;
import com.example.prestabook.service.ContainerServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorContainer {
	
	@Autowired
	ContainerServiceImpl containerServiceImpl;
	
	@GetMapping("/containers")
	public List<Container> listarContainers(){
		return containerServiceImpl.listarContainers();
	}
	
	@PostMapping("/containers")
	public Container crearContainer(@RequestBody Container container) {
		
		return containerServiceImpl.crearContainer(container);
		
	}
	
	
	@GetMapping("/containers/{id}")
	public Container leerContainer(@PathVariable(name="id") Long id) {
		
		Container container= new Container();
		
		container=containerServiceImpl.leerContainer(id);
		
		System.out.println("Container segun ID: "+container);
		
		return container;
	}
	
	@PutMapping("/containers/{id}")
	public Container actualizarContainer(@PathVariable(name="id")Long id,@RequestBody Container container) {
		
		Container container_seleccionado= new Container();
		Container container_actualizado= new Container();
		
		container_seleccionado= containerServiceImpl.leerContainer(id);

		container_seleccionado.setContainer_name(container.getContainer_name());

		
		container_actualizado = containerServiceImpl.actualizarContainer(container_seleccionado);
		
		System.out.println("El container actualizado es: "+ container_actualizado);
		
		return container_actualizado;
	}
	
	@DeleteMapping("/containers/{id}")
	public void borrarContainer(@PathVariable(name="id")Long id) {
		containerServiceImpl.borrarContainer(id);
	}
	
	
}
