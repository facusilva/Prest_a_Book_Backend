package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IUserDAO;
import com.example.prestabook.dto.User;

@Service
public class UserServiceImpl implements IUserService{
	
	//Utilizamos los metodos de la interface IUserDAO, es como si instanciaramos.
	@Autowired
	IUserDAO iUserDAO;
	
	@Override
	public List<User> listarUsers() {
		return iUserDAO.findAll();
	}
	
	@Override
	public User crearUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public User leerUser(Long id) {
		return iUserDAO.findById(id).get();
	}


	@Override
	public User actualizarUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public void borrarUser(Long id) {
		iUserDAO.deleteById(id);
	}

}
