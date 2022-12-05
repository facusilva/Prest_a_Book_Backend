package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Loan;


public interface ILoanDAO extends JpaRepository<Loan, Long>{
	
}
