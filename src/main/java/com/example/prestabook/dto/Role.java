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
@Table(name="roles")

public class Role {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role_name;
	
	@OneToMany
	@JoinColumn(name="id_role")
	private List<Usuario> usuarios;
	
	
	//Constructores
	
	public Role() {
		
	}

	public Role(Long id, String role_name, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.usuarios = usuarios;
	}



	//Setters y getters
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_role")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + ", usuarios=" + usuarios + "]";
	}

	


	

	




	
}