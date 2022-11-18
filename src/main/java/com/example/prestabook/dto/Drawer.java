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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_container")
	private Container container;
	
	@OneToMany
	@JoinColumn(name="id_drawer")
	private List<Book> book;
	
	
	//Constructores
	
	public Drawer() {
		
	}
	
	public Drawer(Long id, Container container) {
		this.id=id;
		this.container=container;
	}

	//Setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Salas [id = " + id +", container " + container + " ] ";
	}

	

	
}
