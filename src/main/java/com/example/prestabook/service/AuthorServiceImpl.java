package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IAuthorDAO;
import com.example.prestabook.dto.Author;

@Service
public class AuthorServiceImpl implements IAuthorService{
	
	//Utilizamos los metodos de la interface IAuthorDAO, es como si instanciaramos.
	@Autowired
	IAuthorDAO iAuthorDAO;
	
	@Override
	public List<Author> listarAuthors() {
		return iAuthorDAO.findAll();
	}
	
	@Override
	public Author crearAuthor(Author author) {
		return iAuthorDAO.save(author);
	}

	@Override
	public Author leerAuthor(Long id) {
		return iAuthorDAO.findById(id).get();
	}

	@Override
	public Author actualizarAuthor(Author author) {
		return iAuthorDAO.save(author);
	}

	@Override
	public void borrarAuthor(Long id) {
		iAuthorDAO.deleteById(id);
	}

}
