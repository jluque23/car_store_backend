package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.Customer;
import com.jluque.sprinboot.backend.apirest.models.services.ICustomerService;

@CrossOrigin()
@RestController()
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customers")
	@ResponseStatus(HttpStatus.OK)
	private List<Customer> index(){
		return customerService.findAll();
	}
	
	@GetMapping("/customers/page/{page}")
	@ResponseStatus(HttpStatus.OK)
	public Page<Customer> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 20);
		return customerService.findAll(pageable);
	}
	
}
