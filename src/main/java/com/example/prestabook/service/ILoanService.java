package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Loan;
import com.example.prestabook.dto.Usuario;

public interface ILoanService {

	//Metodos del CRUD
	
	public List<Loan> listarLoans(); //Listar All 
	
	public Loan crearLoan(Loan loan);	//CREATE
	
	public Loan leerLoan(Long id); // READ
		
	public Loan actualizarLoan(Loan loan); // UPDATE
	
	public void borrarLoan(Long id);// DELETE
	
	public List<Loan> leerLoanByLoanee(Usuario loanee);
	
	public List<Loan> leerLoanByLoaner(Usuario loaner);
	
	public Loan leerLoanByLoaneeBook(Usuario usuario, Book book);
}