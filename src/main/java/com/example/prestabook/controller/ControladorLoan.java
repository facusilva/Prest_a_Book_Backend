package com.example.prestabook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Loan;
import com.example.prestabook.dto.Usuario;
import com.example.prestabook.service.BookServiceImpl;
import com.example.prestabook.service.LoanServiceImpl;
import com.example.prestabook.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorLoan {
	
	@Autowired
	LoanServiceImpl loanServiceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping("/loan")
	public List<Loan> listarLoans(){
		return loanServiceImpl.listarLoans();
	}
	
	@PostMapping("/loan")
	public Loan crearLoan(@RequestBody Loan loan) {
		return loanServiceImpl.crearLoan(loan);
	}
	
	@GetMapping("/loan/loanee/{id_user}")
    public List<Loan> getLoanByLoanee(@PathVariable Long id_user) {
        Usuario loanee = userServiceImpl.leerUser(id_user);
        return loanServiceImpl.leerLoanByLoanee(loanee);
    }
	
	@GetMapping("/loan/loaner/{id_user}")
    public List<Loan> getLoanByLoaner(@PathVariable Long id_user) {
        Usuario loaner = userServiceImpl.leerUser(id_user);
        return loanServiceImpl.leerLoanByLoaner(loaner);
    }
	
	@GetMapping("/loan/byloaneeandbook/{id_user}/{id_book}")
    public Loan leerWishesByUserBook(@PathVariable("id_user") Long id_user, @PathVariable("id_book") Long id_book)  {
        Usuario usuario = userServiceImpl.leerUser(id_user);
        Book book = bookServiceImpl.leerBook(id_book);
        return loanServiceImpl.leerLoanByLoaneeBook(usuario, book);
    }
	
	@GetMapping("/loan/{id}")
	public Loan leerLoan(@PathVariable(name="id") Long id) {
		
		Loan loan= new Loan();
		
		loan=loanServiceImpl.leerLoan(id);
		
		System.out.println("Loan segun ID: "+loan);
		
		return loan;
	}
	
	@PutMapping("/loan/{id}")
	public Loan actualizarLoan(@PathVariable(name="id")Long id,@RequestBody Loan loan) {
		
		Loan loan_seleccionado= new Loan();
		Loan loan_actualizado= new Loan();
		
		loan_seleccionado= loanServiceImpl.leerLoan(id);

		loan_seleccionado.setId_book(loan.getId_book());
		loan_seleccionado.setId_loaner(loan.getId_loaner());
		loan_seleccionado.setId_loanee(loan.getId_loanee());
		loan_seleccionado.setStarting_date(loan.getStarting_date());
		loan_seleccionado.setEnd_date(loan.getEnd_date());
		loan_seleccionado.setActive(loan.getActive());
		
		loan_actualizado = loanServiceImpl.actualizarLoan(loan_seleccionado);
		
		System.out.println("El loan actualizado es: "+ loan_actualizado);
		
		return loan_actualizado;
	}
	
	@DeleteMapping("/loan/{id}")
	public void borrarLoan(@PathVariable(name="id")Long id) {
		loanServiceImpl.borrarLoan(id);
	}
	
	
}
