package com.example.prestabook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.prestabook.dto.Usuario;
import com.example.prestabook.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorUser {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/users")
	public List<Usuario> listarUsers(){
		return userServiceImpl.listarUsers();
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/users")
	public Usuario crearUser(@RequestBody Usuario user) {
		user.setPsswd(bCryptPasswordEncoder.encode(user.getPsswd()));
		return userServiceImpl.crearUser(user);
		
	}
	
	@GetMapping("/users/{id}")
	public Usuario leerUser(@PathVariable(name="id") Long id) {
		
		Usuario user= new Usuario();
		
		user=userServiceImpl.leerUser(id);
		
		System.out.println("User segun ID: "+user);
		
		return user;
	}
	
	@PutMapping("/users/{id}")
	public Usuario actualizarUser(@PathVariable(name="id")Long id,@RequestBody Usuario user) {
		
		Usuario user_seleccionado= new Usuario();
		Usuario user_actualizado= new Usuario();
		
		user_seleccionado= userServiceImpl.leerUser(id);

		user_seleccionado.setUsername(user.getUsername());
		user_seleccionado.setPsswd(user.getPsswd());
		user_seleccionado.setEmail(user.getEmail());
		user_seleccionado.setReal_name(user.getReal_name());
		user_seleccionado.setSurname(user.getSurname());
		user_seleccionado.setBirth_date(user.getBirth_date());
		user_seleccionado.setGender(user.getGender());
		user_seleccionado.setRole(user.getRole());
		
		user_actualizado = userServiceImpl.actualizarUser(user_seleccionado);
		
		System.out.println("El user actualizado es: "+ user_actualizado);
		
		return user_actualizado;
	}
	
	@DeleteMapping("/users/{id}")
	public void borrarUser(@PathVariable(name="id")Long id) {
		userServiceImpl.borrarUser(id);
	}
	
	
}
