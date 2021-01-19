package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import com.jluque.sprinboot.backend.apirest.models.entity.ProductLine;

public interface IProductLineService {

	public List<ProductLine> findAll();
	
	public ProductLine findById(Long id);
	
	public ProductLine save(ProductLine productLine);
}
