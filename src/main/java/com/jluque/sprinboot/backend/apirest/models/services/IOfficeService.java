package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Office;


public interface IOfficeService {
	public List<Office> findAll();
	
	public Page<Office> findAll(Pageable pageable);
	
	public Office save(Office office);
	
	public Office findById(Long id);
		
	public void delete(Long id);
}
