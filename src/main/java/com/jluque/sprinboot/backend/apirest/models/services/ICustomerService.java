package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Customer;

public interface ICustomerService {
	
	public List<Customer> findAll();
	
	public Page<Customer> findAll(Pageable pageable);

	public Customer save(Customer customer);
	
	public Customer findById(Long id);
	
	public void delete(Long id);
}
