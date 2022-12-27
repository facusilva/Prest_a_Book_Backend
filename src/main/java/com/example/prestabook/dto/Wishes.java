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
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;
	
	//Constructores
	public Wishes() {
		
	}

	public Wishes(Long id, Usuario usuario, Book book) {
		this.id = id;
		this.usuario = usuario;
		this.book = book;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getId_user() {
		return usuario;
	}

	public void setId_user(Usuario usuario) {
		this.usuario = usuario;
	}

	public Book getId_book() {
		return book;
	}

	public void setId_book(Book book) {
		this.book = book;
	}

	

	
	
}
