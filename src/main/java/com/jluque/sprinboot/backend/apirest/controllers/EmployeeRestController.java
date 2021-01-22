package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.Employee;
import com.jluque.sprinboot.backend.apirest.models.services.IEmployeeService;

@CrossOrigin()
@RestController()
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> index(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Employee employee = null;

		Map<String, Object> response = new HashMap<>();

		try {
			employee = employeeService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error obtaining data from database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (employee == null) {
			response.put("mensaje", "The employee with ID: ".concat(id.toString().concat(" doesn't exists in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<?> create(@RequestBody Employee employee) {

		Map<String, Object> response = new HashMap<>();

		try {
			employeeService.save(employee);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error inserting this employee on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The employee has been inserted correctly at the database");
		response.put("employee", employee);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
//	
//	@PutMapping("/offices/{id}")
//	public ResponseEntity<?> update(@RequestBody Office office, @PathVariable Long id) {
//		Office officeActually = officeService.findById(id);
//		Office officeUpdated = null;
//
//		Map<String, Object> response = new HashMap<>();
//
//		if (officeActually == null) {
//			response.put("mensaje", "Error: can't be updated, The office ID: "
//					.concat(id.toString().concat(" doesn't exist in database")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//
//		try {
//			officeActually.setAddress_line_1(office.getAddress_line_1());
//			officeActually.setAddress_line_2(office.getAddress_line_2());
//			officeActually.setCity(office.getCity());
//			officeActually.setCountry(office.getCountry());
//			officeActually.setCreate_at(office.getCreate_at());
//			officeActually.setId(office.getId());
//			officeActually.setPhone(office.getPhone());
//			officeActually.setPostal_code(office.getPostal_code());
//			officeActually.setState(office.getState());
//			officeActually.setTerritory(office.getState());
//			
//			officeUpdated = officeService.save(officeActually);
//
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error updating on database");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "The office has been updated succesfully");
//		response.put("office", officeUpdated);
//
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			employeeService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error deleting the employee on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The employee was deleted succesfully!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
