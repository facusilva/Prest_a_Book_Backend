package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IEditorialDAO;
import com.example.prestabook.dto.Editorial;

@Service
public class EditorialServiceImpl implements IEditorialService{
	
	//Utilizamos los metodos de la interface IEditorialDAO, es como si instanciaramos.
	@Autowired
	IEditorialDAO iEditorialDAO;
	
	@Override
	public List<Editorial> listarEditoriales() {
		return iEditorialDAO.findAll();
	}
	
	@Override
	public Editorial crearEditorial(Editorial editorial) {
		return iEditorialDAO.save(editorial);
	}

	@Override
	public Editorial leerEditorial(Long id) {
		System.out.println("AQUÍ: "+id);
		return iEditorialDAO.findById(id).get();
	}


	@Override
	public Editorial actualizarEditorial(Editorial editorial) {
		return iEditorialDAO.save(editorial);
	}

	@Override
	public void borrarEditorial(Long id) {
		iEditorialDAO.deleteById(id);
	}

}
