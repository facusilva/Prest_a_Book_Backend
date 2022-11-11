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

import com.example.prestabook.dto.User;
import com.example.prestabook.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorUser {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public List<User> listarUsers(){
		return userServiceImpl.listarUsers();
	}
	
	@PostMapping("/users")
	public User crearUser(@RequestBody User user) {
		
		return userServiceImpl.crearUser(user);
		
	}
	
	
	@GetMapping("/users/{id}")
	public User leerUser(@PathVariable(name="id") Long id) {
		
		User user= new User();
		
		user=userServiceImpl.leerUser(id);
		
		System.out.println("User segun ID: "+user);
		
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User actualizarUser(@PathVariable(name="id")Long id,@RequestBody User user) {
		
		User user_seleccionado= new User();
		User user_actualizado= new User();
		
		user_seleccionado= userServiceImpl.leerUser(id);

		user_seleccionado.setUsername(user.getUsername());
		user_seleccionado.setPsswd(user.getPsswd());
		user_seleccionado.setEmail(user.getEmail());
		user_seleccionado.setReal_name(user.getReal_name());
		user_seleccionado.setSurname(user.getSurname());
		user_seleccionado.setBirth_date(user.getBirth_date());
		user_seleccionado.setGender(user.getGender());
		
		user_actualizado = userServiceImpl.actualizarUser(user_seleccionado);
		
		System.out.println("El user actualizado es: "+ user_actualizado);
		
		return user_actualizado;
	}
	
	@DeleteMapping("/users/{id}")
	public void borrarUser(@PathVariable(name="id")Long id) {
		userServiceImpl.borrarUser(id);
	}
	
	
}
