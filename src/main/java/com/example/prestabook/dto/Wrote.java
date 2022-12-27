package com.example.prestabook.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wrote")

public class Wrote {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_author")
	private Author id_author;
	
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;
	
	//Constructores
	public Wrote() {
		
	}

	public Wrote(Long id, Author id_author, Book book) {
		this.id = id;
		this.id_author = id_author;
		this.book = book;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Author getId_author() {
		return id_author;
	}

	public void setId_author(Author id_author) {
		this.id_author = id_author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	
	
	
}
