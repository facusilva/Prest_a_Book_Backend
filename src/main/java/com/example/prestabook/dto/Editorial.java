package com.example.prestabook.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="editorial")

public class Editorial {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="editorial_name")
	private String name;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private Usuario id_user;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Book> books;
	
	//Constructores
	
	public Editorial() {
		
	}
	
	public Editorial(Long id, String name, String country, Usuario id_user, List<Book> books) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.id_user = id_user;
		this.books = books;
	}
	
	//Setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEditorial_name() {
		return name;
	}

	public void setEditorial_name(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Usuario getId_user() {
		return id_user;
	}

	public void setId_user(Usuario id_user) {
		this.id_user = id_user;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_editorial")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	//To string personalizado
	
	
}
