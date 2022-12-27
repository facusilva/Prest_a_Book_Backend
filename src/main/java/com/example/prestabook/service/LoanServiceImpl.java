package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.ILoanDAO;
import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Loan;
import com.example.prestabook.dto.Usuario;

@Service
public class LoanServiceImpl implements ILoanService{
	
	//Utilizamos los metodos de la interface ILoanDAO, es como si instanciaramos.
	@Autowired
	ILoanDAO iLoanDAO;
	
	@Override
	public List<Loan> listarLoans() {
		return iLoanDAO.findAll();
	}
	
	@Override
	public Loan crearLoan(Loan loan) {
		return iLoanDAO.save(loan);
	}

	@Override
	public Loan leerLoan(Long id) {
		return iLoanDAO.findById(id).get();
	}

	@Override
	public Loan actualizarLoan(Loan loan) {
		return iLoanDAO.save(loan);
	}

	@Override
	public void borrarLoan(Long id) {
		iLoanDAO.deleteById(id);
	}

	@Override
	public List<Loan> leerLoanByLoanee(Usuario loanee) {
		return iLoanDAO.findByLoanee(loanee);
	}
	
	public List<Loan> leerLoanByLoaner(Usuario loaner) {
		return iLoanDAO.findByLoaner(loaner);
	}
	
	public Loan leerLoanByLoaneeBook(Usuario usuario, Book book) {
        return iLoanDAO.findByLoaneeAndBook(usuario, book);
    }

}
