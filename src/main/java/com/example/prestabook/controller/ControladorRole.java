
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

import com.example.prestabook.dto.Role;
import com.example.prestabook.service.RoleServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorRole {
	
	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	@GetMapping("/roles")
	public List<Role> listarRoles(){
		return roleServiceImpl.listarRoles();
	}
	
	@PostMapping("/roles")
	public Role crearRole(@RequestBody Role role) {
		return roleServiceImpl.crearRole(role);
	}
	
	@GetMapping("/roles/{id}")
	public Role leerRole(@PathVariable(name="id") Long id) {
		
		Role role= new Role();
		
		role=roleServiceImpl.leerRole(id);
		
		System.out.println("Role segun ID: "+role);
		
		return role;
	}
	
	@PutMapping("/roles/{id}")
	public Role actualizarRole(@PathVariable(name="id")Long id,@RequestBody Role role) {
		
		Role role_seleccionado= new Role();
		Role role_actualizado= new Role();
		
		role_seleccionado= roleServiceImpl.leerRole(id);

		role_seleccionado.setRole_name(role.getRole_name());

		
		role_actualizado = roleServiceImpl.actualizarRole(role_seleccionado);
		
		System.out.println("El role actualizado es: "+ role_actualizado);
		
		return role_actualizado;
	}
	
	@DeleteMapping("/roles/{id}")
	public void borrarRole(@PathVariable(name="id")Long id) {
		roleServiceImpl.borrarRole(id);
	}
	
	
}
