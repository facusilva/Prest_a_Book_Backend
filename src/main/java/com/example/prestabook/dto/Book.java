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
	@JoinColumn(name="id_editorial")
	private Editorial id_editorial;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User id_user;
	
	//Constructores
	
	public Book() {

	}

	public Book(int id, String isbn, String title, int num_pages, String genre, Editorial id_editorial, User id_user) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.num_pages = num_pages;
		this.genre = genre;
		this.id_editorial = id_editorial;
		this.id_user = id_user;
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

	public Editorial getId_editorial() {
		return id_editorial;
	}

	public void setId_editorial(Editorial id_editorial) {
		this.id_editorial = id_editorial;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}
	
	



	
	

	
	
	
	
}
