package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IContainerDAO;
import com.example.prestabook.dto.Container;

@Service
public class ContainerServiceImpl implements IContainerService{
	
	//Utilizamos los metodos de la interface IContainerDAO, es como si instanciaramos.
	@Autowired
	IContainerDAO iContainerDAO;
	
	@Override
	public List<Container> listarContainers() {
		return iContainerDAO.findAll();
	}
	
	@Override
	public Container crearContainer(Container container) {
		return iContainerDAO.save(container);
	}

	@Override
	public Container leerContainer(Long id) {
		return iContainerDAO.findById(id).get();
	}


	@Override
	public Container actualizarContainer(Container container) {
		return iContainerDAO.save(container);
	}

	@Override
	public void borrarContainer(Long id) {
		iContainerDAO.deleteById(id);
	}

}