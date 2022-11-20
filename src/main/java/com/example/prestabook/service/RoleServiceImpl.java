package com.example.prestabook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestabook.dao.IRoleDAO;
import com.example.prestabook.dto.Role;

@Service
public class RoleServiceImpl implements IRoleService{
	
	//Utilizamos los metodos de la interface IRoleDAO, es como si instanciaramos.
	@Autowired
	IRoleDAO iRoleDAO;
	
	@Override
	public List<Role> listarRoles() {
		return iRoleDAO.findAll();
	}
	
	@Override
	public Role crearRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public Role leerRole(Long id) {
		return iRoleDAO.findById(id).get();
	}

	@Override
	public Role actualizarRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public void borrarRole(Long id) {
		iRoleDAO.deleteById(id);
	}

}
