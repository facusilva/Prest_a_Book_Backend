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

import com.example.prestabook.dto.Author;
import com.example.prestabook.service.AuthorServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorAuthor {
	
	@Autowired
	AuthorServiceImpl authorServiceImpl;
	
	@GetMapping("/authors")
	public List<Author> listarAuthors(){
		return authorServiceImpl.listarAuthors();
	}
	
	@PostMapping("/authors")
	public Author crearAuthor(@RequestBody Author author) {
		return authorServiceImpl.crearAuthor(author);
	}
	
	@GetMapping("/authors/{id}")
	public Author leerAuthor(@PathVariable(name="id") Long id) {
		
		Author author= new Author();
		
		author=authorServiceImpl.leerAuthor(id);
		
		System.out.println("Author segun ID: "+author);
		
		return author;
	}
	
	@PutMapping("/authors/{id}")
	public Author actualizarAuthor(@PathVariable(name="id")Long id,@RequestBody Author author) {
		
		Author author_seleccionado= new Author();
		Author author_actualizado= new Author();
		
		author_seleccionado= authorServiceImpl.leerAuthor(id);

		author_seleccionado.setName(author.getName());
		author_seleccionado.setSurname(author.getSurname());
		author_seleccionado.setBirth_date(author.getBirth_date());
		author_seleccionado.setNationality(author.getNationality());
		author_seleccionado.setDescr(author.getDescr());
		author_seleccionado.setGender(author.getGender());
		
		author_actualizado = authorServiceImpl.actualizarAuthor(author_seleccionado);
		
		System.out.println("El author actualizado es: "+ author_actualizado);
		
		return author_actualizado;
	}
	
	@DeleteMapping("/authors/{id}")
	public void borrarAuthor(@PathVariable(name="id")Long id) {
		authorServiceImpl.borrarAuthor(id);
	}
	
	
}
