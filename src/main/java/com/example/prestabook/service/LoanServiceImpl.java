package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.ILoanDAO;
import com.example.prestabook.dto.Loan;

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

}
