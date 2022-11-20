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
	private Book id_book;
	
	@ManyToOne
	@JoinColumn(name="id_loaner")
	private Usuario id_loaner;
	
	@ManyToOne
	@JoinColumn(name="id_loanee")
	private Usuario id_loanee;
	
	private Date starting_date;
	private Date end_date;
	

	//Constructores
	public Loan() {
		
	}

	public Loan(Long id, Book id_book, Usuario id_loaner, Usuario id_loanee, Date starting_date, Date end_date) {
		this.id = id;
		this.id_book = id_book;
		this.id_loaner = id_loaner;
		this.id_loanee = id_loanee;
		this.starting_date = starting_date;
		this.end_date = end_date;
	}

	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getId_book() {
		return id_book;
	}

	public void setId_book(Book id_book) {
		this.id_book = id_book;
	}

	public Usuario getId_loaner() {
		return id_loaner;
	}

	public void setId_loaner(Usuario id_loaner) {
		this.id_loaner = id_loaner;
	}

	public Usuario getId_loanee() {
		return id_loanee;
	}

	public void setId_loanee(Usuario id_loanee) {
		this.id_loanee = id_loanee;
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

	@Override
	public String toString() {
		return "Loan [id=" + id + ", id_book=" + id_book + ", id_loaner=" + id_loaner + ", id_loanee=" + id_loanee
				+ ", starting_date=" + starting_date + ", end_date=" + end_date + "]";
	}

	
	
	
	
}
