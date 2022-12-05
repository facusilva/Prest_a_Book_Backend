package com.example.prestabook.service;

import java.util.List;

import com.example.prestabook.dto.Loan;

public interface ILoanService {

	//Metodos del CRUD
	
	public List<Loan> listarLoans(); //Listar All 
	
	public Loan crearLoan(Loan loan);	//CREATE
	
	public Loan leerLoan(Long id); // READ
		
	public Loan actualizarLoan(Loan loan); // UPDATE
	
	public void borrarLoan(Long id);// DELETE
	
	
}