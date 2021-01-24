package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jluque.sprinboot.backend.apirest.models.dao.ICustomerDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerDao.findAll(pageable);
	}

	@Override
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		customerDao.deleteById(id);
	}

}
