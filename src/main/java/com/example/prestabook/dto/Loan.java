package com.example.prestabook.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan")

public class Loan {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="id_loaner")
	private Usuario loaner;
	
	@ManyToOne
	@JoinColumn(name="id_loanee")
	private Usuario loanee;
	
	private Date starting_date;
	private Date end_date;
	private Boolean active;

	//Constructores
	public Loan() {
		
	}

	public Loan(Long id, Book book, Usuario loaner, Usuario loanee, Date starting_date, Date end_date, Boolean active) {
		this.id = id;
		this.book = book;
		this.loaner = loaner;
		this.loanee = loanee;
		this.starting_date = starting_date;
		this.end_date = end_date;
		this.active = active;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getId_book() {
		return book;
	}

	public void setId_book(Book book) {
		this.book = book;
	}

	public Usuario getId_loaner() {
		return loaner;
	}

	public void setId_loaner(Usuario loaner) {
		this.loaner = loaner;
	}

	public Usuario getId_loanee() {
		return loanee;
	}

	public void setId_loanee(Usuario loanee) {
		this.loanee = loanee;
	}

	public Date getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
}
