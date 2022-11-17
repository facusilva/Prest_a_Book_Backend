package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IDrawerDAO;
import com.example.prestabook.dto.Drawer;

@Service
public class DrawerServiceImpl implements IDrawerService{
	
	//Utilizamos los metodos de la interface IDrawerDAO, es como si instanciaramos.
	@Autowired
	IDrawerDAO iDrawerDAO;
	
	@Override
	public List<Drawer> listarDrawers() {
		return iDrawerDAO.findAll();
	}
	
	@Override
	public Drawer crearDrawer(Drawer drawer) {
		return iDrawerDAO.save(drawer);
	}

	@Override
	public Drawer leerDrawer(String id) {
		return iDrawerDAO.findById(id).get();
	}


	@Override
	public Drawer actualizarDrawer(Drawer drawer) {
		return iDrawerDAO.save(drawer);
	}

	@Override
	public void borrarDrawer(String id) {
		iDrawerDAO.deleteById(id);
	}

}