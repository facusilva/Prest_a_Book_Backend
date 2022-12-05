package com.example.prestabook.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wishes")

public class Wishes {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private Usuario id_user;
	
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book id_book;
	
	//Constructores
	public Wishes() {
		
	}

	public Wishes(Long id, Usuario id_user, Book id_book) {
		this.id = id;
		this.id_user = id_user;
		this.id_book = id_book;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getId_user() {
		return id_user;
	}

	public void setId_user(Usuario id_user) {
		this.id_user = id_user;
	}

	public Book getId_book() {
		return id_book;
	}

	public void setId_book(Book id_book) {
		this.id_book = id_book;
	}

	

	
	
}
