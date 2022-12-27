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

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Usuario;
import com.example.prestabook.dto.Wishes;
import com.example.prestabook.service.BookServiceImpl;
import com.example.prestabook.service.UserServiceImpl;
import com.example.prestabook.service.WishesServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorWishes {
	
	@Autowired
	WishesServiceImpl wishesServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
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
	
	@GetMapping("/wishes/user/{id_user}")
	public List<Wishes> getWishesByUser(@PathVariable Long id_user) {
		Usuario usuario = userServiceImpl.leerUser(id_user);
		return wishesServiceImpl.leerBookByUser(usuario);	
	}
	
	@GetMapping("/wishes/byuserandbook/{id_user}/{id_book}")
    public Wishes leerWishesByUserBook(@PathVariable("id_user") Long id_user, @PathVariable("id_book") Long id_book)  {
        Usuario usuario = userServiceImpl.leerUser(id_user);
        Book book = bookServiceImpl.leerBook(id_book);
        return wishesServiceImpl.leerWishByUserBook(usuario, book);
    }
	
	public Wishes leerWishByUserBook(Usuario usuario, Book book) {
        return wishesServiceImpl.leerWishByUserBook(usuario, book);
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
