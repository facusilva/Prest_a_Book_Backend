package com.example.prestabook.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="editorial")

public class Editorial {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String editorial_name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	//Constructores
	
	public Editorial() {
		
	}
	
	public Editorial(Long id, String editorial_name, User user) {
		this.id=id;
		this.editorial_name=editorial_name;
		this.user=user;
	}

	//Setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEditorial_name() {
		return editorial_name;
	}

	public void setEditorial_name(String editorial_name) {
		this.editorial_name = editorial_name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	//To string personalizado
	@Override
	public String toString() {
		return "Salas [id = " + id +", editorial name " +editorial_name+ ",user " +user+ " ] ";
	}

	
}
