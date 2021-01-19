package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.ProductLine;
import com.jluque.sprinboot.backend.apirest.models.services.IProductLineService;

@CrossOrigin()
@RestController()
@RequestMapping("/api")
public class ProductLineRestController {

	@Autowired
	private IProductLineService productLineService;
	
	@GetMapping("/productlines")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductLine> index(){
		return productLineService.findAll();
	}
	
	@GetMapping("/productlines/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		ProductLine productLine = null;

		Map<String, Object> response = new HashMap<>();

		try {
			productLine = productLineService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (productLine == null) {
			response.put("mensaje", "El Product line ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ProductLine>(productLine, HttpStatus.OK);
	}
	
	@PostMapping("/productlines")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductLine crear(@RequestBody ProductLine productLine) {
		return productLineService.save(productLine);
	}
	
	@PutMapping("/productlines/{id}")
	public ResponseEntity<?> update(@RequestBody ProductLine productLine, @PathVariable Long id) {
		ProductLine productLineActually = productLineService.findById(id);
		ProductLine productLineUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (productLineActually == null) {
			response.put("mensaje", "Error: Can't be edited, The Product Line ID: "
					.concat(id.toString().concat(" Doesn't exist in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			productLineActually.setDescription(productLine.getDescription());
			productLineActually.setImage(productLine.getImage());
			productLineActually.setProductLine(productLine.getProductLine());
			
			productLineUpdated = productLineService.save(productLineActually);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error updating the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Product line has been updated succesfully");
		response.put("product_line", productLineUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
