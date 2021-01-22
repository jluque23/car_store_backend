package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Employee;

public interface IEmployeeService {
	
	public List<Employee> findAll();
	
	public Page<Employee> findAll(Pageable pageable);
	
	public Employee save(Employee employee);
	
	public Employee findById(Long id);
	
	public void delete(Long id);
}
