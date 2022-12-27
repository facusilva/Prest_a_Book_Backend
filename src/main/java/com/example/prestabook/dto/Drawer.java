package com.example.prestabook.dto;

import java.util.List;

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
@Table(name="drawer")

public class Drawer {

	//Atributos de la entidad Empleado
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="id_container")
	private Container container;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Book> book;
	
	
	//Constructores
	public Drawer() {
		
	}

	public Drawer(String id, Container container, List<Book> book) {
		this.id = id;
		this.container = container;
		this.book = book;
	}

	
	//Setters y getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_drawer")
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Salas [id = " + id +", container " + container + " ] ";
	}

	

	
}
