package com.example.prestabook.dto;

import java.util.Date;
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
@Table(name="users")

public class Usuario {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String psswd;
	private String email;
	private String real_name;
	private String surname;
	private Date birth_date;
	private String gender;
	
	@OneToMany
	@JoinColumn(name="id_user")
	private List<Editorial> editorial;
	
	@OneToMany
	@JoinColumn(name="id_user")
	private List<Book> books;
	
	@OneToMany
	@JoinColumn(name="id_user")
	private List<Wishes> wishes;

	@ManyToOne
    @JoinColumn(name="id_role")
    private Role id_role;
	
	@OneToMany
	@JoinColumn(name="id_loaner")
	private List<Loan> loaner;
	
	@OneToMany
	@JoinColumn(name="id_loaner")
	private List<Loan> loanee;
	
	//Constructores
	public Usuario() {
		
	}

	public Usuario(Long id, String username, String psswd, String email, String real_name, String surname, Date birth_date,
			String gender, List<Editorial> editorial, List<Book> books, List<Wishes> wishes, List<Loan> loaner,
			List<Loan> loanee, Role id_role) {
		super();
		this.id = id;
		this.username = username;
		this.psswd = psswd;
		this.email = email;
		this.real_name = real_name;
		this.surname = surname;
		this.birth_date = birth_date;
		this.gender = gender;
		this.editorial = editorial;
		this.books = books;
		this.wishes = wishes;
		this.loaner = loaner;
		this.loanee = loanee;
		this.id_role = id_role;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsswd() {
		return psswd;
	}

	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_user")
	public List<Editorial> getEditorial() {
		return editorial;
	}

	public void setEditorial(List<Editorial> editorial) {
		this.editorial = editorial;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_user")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_user")
	public List<Wishes> getWishes() {
		return wishes;
	}

	public void setWishes(List<Wishes> wishes) {
		this.wishes = wishes;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_loaner")
	public List<Loan> getLoaner() {
		return loaner;
	}

	public void setLoaner(List<Loan> loaner) {
		this.loaner = loaner;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_loanee")
	public List<Loan> getLoanee() {
		return loanee;
	}

	public void setLoanee(List<Loan> loanee) {
		this.loanee = loanee;
	}

	public Role getId_role() {
		return id_role;
	}

	public void setId_role(Role id_role) {
		this.id_role = id_role;
	}

}
