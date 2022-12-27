package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IWishesDAO;
import com.example.prestabook.dto.Book;
import com.example.prestabook.dto.Usuario;
import com.example.prestabook.dto.Wishes;

@Service
public class WishesServiceImpl implements IWishesService{
	
	//Utilizamos los metodos de la interface IWishesDAO, es como si instanciaramos.
	@Autowired
	IWishesDAO iWishesDAO;
	
	@Override
	public List<Wishes> listarWishes() {
		return iWishesDAO.findAll();
	}
	
	@Override
	public Wishes crearWishes(Wishes wishes) {
		return iWishesDAO.save(wishes);
	}

	@Override
	public Wishes leerWishes(Long id) {
		return iWishesDAO.findById(id).get();
	}


	@Override
	public Wishes actualizarWishes(Wishes wishes) {
		return iWishesDAO.save(wishes);
	}

	@Override
	public void borrarWishes(Long id) {
		iWishesDAO.deleteById(id);
	}
	
	public List<Wishes> leerBookByUser(Usuario usuario) {
        return iWishesDAO.findByUsuario(usuario);
    }
	
	public Wishes leerWishByUserBook(Usuario usuario, Book book) {
        return iWishesDAO.findByUsuarioAndBook(usuario, book);
    }


}