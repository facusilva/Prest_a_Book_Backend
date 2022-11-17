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
	@JoinColumn(name="author")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="book")
	private Book book;
	
	//Constructores
	public Wrote() {
		
	}

	public Wrote(Long id, Author author, Book book) {
		this.id = id;
		this.author = author;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "Wrote [id=" + id + ", author=" + author + ", book=" + book + "]";
	}

	
	
}
