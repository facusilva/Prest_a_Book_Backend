package com.example.prestabook.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="container")

public class Container {

	//Atributos de la entidad Empleado
	@Id
	private Long id;
	private String container_name;
	
	@OneToMany
	@JoinColumn(name="id_container")
	private List<Drawer> drawer;
	
	
	//Constructores
	
	public Container() {
		
	}
	
	public Container(Long id, String container_name) {
		this.id=id;
		this.container_name=container_name;
	}

	//Setters y getters
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContainer_name() {
		return container_name;
	}

	public void setContainer_name(String container_name) {
		this.container_name = container_name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Drawer")
	public List<Drawer> getDrawer() {
		return drawer;
	}

	public void setDrawer(List<Drawer> drawer) {
		this.drawer = drawer;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Salas [id = " + id +", nombre = " + container_name + " ] ";
	}



	
}