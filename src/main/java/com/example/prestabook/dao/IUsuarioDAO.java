package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Usuario;


public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);
	
}
