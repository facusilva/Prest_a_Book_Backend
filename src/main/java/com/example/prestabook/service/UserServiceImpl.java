package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IUsuarioDAO;
import com.example.prestabook.dto.Usuario;

@Service
public class UserServiceImpl implements IUserService{
	
	//Utilizamos los metodos de la interface IUsuarioDAO, es como si instanciaramos.
	@Autowired
	IUsuarioDAO iUserDAO;
	
	@Override
	public List<Usuario> listarUsers() {
		return iUserDAO.findAll();
	}
	
	@Override
	public Usuario crearUser(Usuario user) {
		return iUserDAO.save(user);
	}

	@Override
	public Usuario leerUser(Long id) {
		return iUserDAO.findById(id).get();
	}


	@Override
	public Usuario actualizarUser(Usuario user) {
		return iUserDAO.save(user);
	}

	@Override
	public void borrarUser(Long id) {
		iUserDAO.deleteById(id);
	}

}
