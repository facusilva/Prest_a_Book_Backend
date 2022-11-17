package com.example.prestabook.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestabook.dto.Wrote;


public interface IWroteDAO extends JpaRepository<Wrote, Long>{
	
}
