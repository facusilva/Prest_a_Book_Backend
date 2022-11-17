package com.example.prestabook.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="book")

public class Book {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String isbn;
	private String title;
	private int num_pages;
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="editorial")
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name="author")
	private Author author;
	
	//Constructores
	
	public Book() {

	}
	
	public Book(String isbn, String title, int num_pages, String genre, Editorial editorial) {
		this.isbn = isbn;
		this.title = title;
		this.num_pages = num_pages;
		this.genre = genre;
		this.editorial = editorial;
	}


	//Setters y getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getNum_pages() {
		return num_pages;
	}


	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	//Método toString
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", num_pages=" + num_pages + ", genre=" + genre
				+ ", editorial=" + editorial + "]";
	}

	

	
	
	
	
}
