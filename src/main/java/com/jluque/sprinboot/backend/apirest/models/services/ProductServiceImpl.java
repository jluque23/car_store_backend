package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jluque.sprinboot.backend.apirest.models.dao.IProductDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDao.findAll(pageable);
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		productDao.deleteById(id);
		
	}

	@Override
	public List<Product> findByProductLine(Long productLineId) {
		return productDao.findByProductLineId(productLineId);
	}

}
