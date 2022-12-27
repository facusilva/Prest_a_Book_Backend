package com.example.prestabook.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Loan;
import com.example.prestabook.dto.Usuario;


public interface ILoanDAO extends JpaRepository<Loan, Long>{
	
	List<Loan> findByLoanee(Usuario loanee);
	List<Loan> findByLoaner(Usuario loaner);
	Loan findByLoaneeAndBook (Usuario usuario, Book book);
	
}
