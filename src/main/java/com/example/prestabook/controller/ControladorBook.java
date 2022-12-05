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
import com.example.prestabook.service.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorBook {
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping("/books")
	public List<Book> listarBooks(){
		return bookServiceImpl.listarBooks();
	}
	
	@PostMapping("/books")
	public Book crearBook(@RequestBody Book book) {
		
		return bookServiceImpl.crearBook(book);
		
	}
	
	@GetMapping("/books/{id}")
	public Book leerBook(@PathVariable(name="id") Long id) {
		
		Book book= new Book();
		
		book=bookServiceImpl.leerBook(id);
		
		System.out.println("Book segun ID: "+book);
		
		return book;
	}
	
	@PutMapping("/books/{id}")
	public Book actualizarBook(@PathVariable(name="id")Long id,@RequestBody Book book) {
		
		Book book_seleccionado= new Book();
		Book book_actualizado= new Book();
		
		book_seleccionado= bookServiceImpl.leerBook(id);

		book_seleccionado.setIsbn(book.getIsbn());
		book_seleccionado.setTitle(book.getTitle());
		book_seleccionado.setNum_pages(book.getNum_pages());
		book_seleccionado.setGenre(book.getGenre());
		book_seleccionado.setId_drawer(book.getId_drawer());
		book_seleccionado.setId_user(book.getId_user());
		book_seleccionado.setId_editorial(book.getId_editorial());
		
		book_actualizado = bookServiceImpl.actualizarBook(book_seleccionado);
		
		System.out.println("El book actualizado es: "+ book_actualizado);
		
		return book_actualizado;
	}
	
	@DeleteMapping("/books/{id}")
	public void borrarBook(@PathVariable(name="id")Long id) {
		bookServiceImpl.borrarBook(id);
	}
	
	
}
