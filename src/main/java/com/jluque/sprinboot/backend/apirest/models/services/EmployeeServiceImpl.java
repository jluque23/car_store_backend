package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jluque.sprinboot.backend.apirest.models.dao.IEmployeeDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Page<Employee> findAll(Pageable pageable) {
		return employeeDao.findAll(pageable);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		employeeDao.deleteById(id);
	}

}
