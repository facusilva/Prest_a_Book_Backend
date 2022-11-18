package com.example.prestabook.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="authors")

public class Author {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;
	private Date birth_date;
	private String nationality;
	private String descr;
	private String gender;
	
	
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

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", birth_date=" + birth_date
				+ ", nationality=" + nationality + ", descr=" + descr + ", gender=" + gender + "]";
	}
	
	



	
}