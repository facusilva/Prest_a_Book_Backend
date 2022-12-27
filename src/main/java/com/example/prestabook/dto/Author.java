package com.example.prestabook.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="author")

public class Author {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="author_name")
	private String name;
	private String surname;
	private Date birth_date;
	private String nationality;
	private String descr;
	private String gender;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Wrote> wrote;
	
	//Constructores
	public Author() {
		
	}

	public Author(Long id, String name, String surname, Date birth_date, String nationality, String descr,String gender) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birth_date = birth_date;
		this.nationality = nationality;
		this.descr = descr;
		this.gender = gender;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirth_date() {
		return birth_date;
	}
	
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_author")
	public List<Wrote> getWrote() {
		return wrote;
	}

	public void setWrote(List<Wrote> wrote) {
		this.wrote = wrote;
	}


	
	



	
}
