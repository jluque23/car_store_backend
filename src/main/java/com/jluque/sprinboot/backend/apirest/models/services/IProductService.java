package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	
	public Page<Product> findAll(Pageable pageable);
	
	public Product save(Product product);
	
	public Product findById(Long id);
	
	public List<Product> findByProductLine(Long productLineId);
	
	public void delete(Long id);
	
}
