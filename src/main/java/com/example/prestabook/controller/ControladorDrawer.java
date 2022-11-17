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

import com.example.prestabook.dto.Drawer;
import com.example.prestabook.service.DrawerServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorDrawer {
	
	@Autowired
	DrawerServiceImpl drawerServiceImpl;
	
	@GetMapping("/drawers")
	public List<Drawer> listarDrawers(){
		return drawerServiceImpl.listarDrawers();
	}
	
	@PostMapping("/drawers")
	public Drawer crearDrawer(@RequestBody Drawer drawer) {
		
		return drawerServiceImpl.crearDrawer(drawer);
		
	}
	
	
	@GetMapping("/drawers/{id}")
	public Drawer leerDrawer(@PathVariable(name="id") String id) {
		
		Drawer drawer= new Drawer();
		
		drawer=drawerServiceImpl.leerDrawer(id);
		
		System.out.println("Drawer segun ID: "+drawer);
		
		return drawer;
	}
	
	@PutMapping("/drawers/{id}")
	public Drawer actualizarDrawer(@PathVariable(name="id")String id,@RequestBody Drawer drawer) {
		
		Drawer drawer_seleccionado= new Drawer();
		Drawer drawer_actualizado= new Drawer();
		
		drawer_seleccionado= drawerServiceImpl.leerDrawer(id);

		drawer_seleccionado.setContainer(drawer.getContainer());

		
		drawer_actualizado = drawerServiceImpl.actualizarDrawer(drawer_seleccionado);
		
		System.out.println("El drawer actualizado es: "+ drawer_actualizado);
		
		return drawer_actualizado;
	}
	
	@DeleteMapping("/drawers/{id}")
	public void borrarDrawer(@PathVariable(name="id")String id) {
		drawerServiceImpl.borrarDrawer(id);
	}
	
	
}
