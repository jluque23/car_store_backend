package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.Office;
import com.jluque.sprinboot.backend.apirest.models.services.IOfficeService;

@CrossOrigin()
@RestController()
@RequestMapping("/api")
public class OfficeRestController {

	@Autowired
	private IOfficeService officeService;
	
	@GetMapping("/offices")
	public List<Office> index(){
		return officeService.findAll();
	}
	
	@GetMapping("/offices/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Office office = null;

		Map<String, Object> response = new HashMap<>();

		try {
			office = officeService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error obtaining data from database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (office == null) {
			response.put("mensaje", "The office with ID: ".concat(id.toString().concat(" doesn't exists in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Office>(office, HttpStatus.OK);
	}
	
	@PostMapping("/offices")
	public ResponseEntity<?> create(@RequestBody Office office) {

		Map<String, Object> response = new HashMap<>();

		try {
			officeService.save(office);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error inserting this office on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The office has been inserted correctly at the database");
		response.put("product", office);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/offices/{id}")
	public ResponseEntity<?> update(@RequestBody Office office, @PathVariable Long id) {
		Office officeActually = officeService.findById(id);
		Office officeUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (officeActually == null) {
			response.put("mensaje", "Error: can't be updated, The office ID: "
					.concat(id.toString().concat(" doesn't exist in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			officeActually.setAddress_line_1(office.getAddress_line_1());
			officeActually.setAddress_line_2(office.getAddress_line_2());
			officeActually.setCity(office.getCity());
			officeActually.setCountry(office.getCountry());
			officeActually.setCreate_at(office.getCreate_at());
			officeActually.setId(office.getId());
			officeActually.setPhone(office.getPhone());
			officeActually.setPostal_code(office.getPostal_code());
			officeActually.setState(office.getState());
			officeActually.setTerritory(office.getState());
			
			officeUpdated = officeService.save(officeActually);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error updating on database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The office has been updated succesfully");
		response.put("office", officeUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/offices/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			officeService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error deleting the office on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The office was deleted succesfully!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/offices/page/{page}")
	@ResponseStatus(HttpStatus.OK)
	public Page<Office> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 10);
		return officeService.findAll(pageable);
	}

}
