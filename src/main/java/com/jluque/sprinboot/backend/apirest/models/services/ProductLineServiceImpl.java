package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.IProductLineDao;
import com.jluque.sprinboot.backend.apirest.models.entity.ProductLine;

@Service
public class ProductLineServiceImpl implements IProductLineService{

	@Autowired
	private IProductLineDao productLineDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductLine> findAll() {
		return productLineDao.findAll();
	}

	@Override
	@Transactional()
	public ProductLine findById(Long id) {
		return productLineDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public ProductLine save(ProductLine productLine) {
		return productLineDao.save(productLine);
	}

}
