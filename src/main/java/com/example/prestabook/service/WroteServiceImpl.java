package com.example.prestabook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IWroteDAO;
import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Wrote;

@Service
public class WroteServiceImpl implements IWroteService{
	
	//Utilizamos los metodos de la interface IWroteDAO, es como si instanciaramos.
	@Autowired
	IWroteDAO iWroteDAO;
	
	@Override
	public List<Wrote> listarWrotes() {
		return iWroteDAO.findAll();
	}
	
	@Override
	public Wrote crearWrote(Wrote user) {
		return iWroteDAO.save(user);
	}

	@Override
	public Wrote leerWrote(Long id) {
		return iWroteDAO.findById(id).get();
	}

	@Override
	public Wrote actualizarWrote(Wrote user) {
		return iWroteDAO.save(user);
	}

	@Override
	public void borrarWrote(Long id) {
		iWroteDAO.deleteById(id);
	}

	public Wrote leerWroteByBook(Book book) {
        return iWroteDAO.findByBook(book);
    }
	
}
