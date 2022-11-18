package com.example.prestabook.dto;

import java.util.Date;
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
@Table(name="users")

public class User {

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
	
	/*@OneToMany
	@JoinColumn(name="user_id")
	private List<Books> loanBook;
	@ManyToMany
	
	*/
	
	//Constructores
	
	public User() {
		
	}
	
	public User(Long id, String username, String psswd, String email, String real_name, String surname, Date birth_date, String gender) {
		this.id=id;
		this.username=username;
		this.psswd=psswd;
		this.email=email;
		this.real_name=real_name;
		this.surname=surname;
		this.birth_date=birth_date;
		this.gender=gender;
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

	//To string personalizado
	@Override
	public String toString() {
		return "Users [id = " + id +", username = " + username +", password" + psswd + ", email " +email+ ", real name " +real_name+ ", surname "
				+surname+ ", birth date " +birth_date+ ", gender " + gender+ "] ";

	}
}
