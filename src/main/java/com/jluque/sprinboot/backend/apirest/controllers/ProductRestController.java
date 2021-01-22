package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

import com.jluque.sprinboot.backend.apirest.models.entity.Product;
import com.jluque.sprinboot.backend.apirest.models.services.IProductService;

@CrossOrigin()
@RestController()
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> index(){
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Product product = null;

		Map<String, Object> response = new HashMap<>();

		try {
			product = productService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error obtaining data from database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (product == null) {
			response.put("mensaje", "The product with ID: ".concat(id.toString().concat(" doesn't exists in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/products/findbyproductline/{productLineId}")
	public ResponseEntity<?> findByProductLine(@PathVariable Long productLineId){
		List <Product> productList = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			productList = productService.findByProductLine(productLineId);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error obtaining data from database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(productList.isEmpty()) {
			response.put("mensaje", "The product line with ID: ".concat(productLineId.toString().concat(" doesn't exists in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> create(@RequestBody Product product) {

		Map<String, Object> response = new HashMap<>();

		try {
			productService.save(product);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error inserting this product on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The product has been inserted correctly at the database");
		response.put("product", product);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id) {
		Product productActually = productService.findById(id);
		Product productUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (productActually == null) {
			response.put("mensaje", "Error: can't be updated, The product ID: "
					.concat(id.toString().concat(" doesn't exist in database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			productActually.setBuy_price(product.getBuy_price());
			productActually.setId(product.getId());
			productActually.setProduct_code(product.getProduct_code());
			productActually.setProduct_description(product.getProduct_description());
			productActually.setProduct_name(product.getProduct_name());
			productActually.setProduct_scale(product.getProduct_scale());
			productActually.setProduct_vendor(product.getProduct_vendor());
			productActually.setProductLine(product.getProductLine());
			productActually.setQuantity_stock(product.getQuantity_stock());
			productActually.setSell_price(product.getSell_price());
			
			productUpdated = productService.save(productActually);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error updating on database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The product has been updated succesfully");
		response.put("usuario", productUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			productService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error deleting the product on the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "The product was deleted succesfully!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
