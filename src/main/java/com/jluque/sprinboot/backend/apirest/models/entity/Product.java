package com.jluque.sprinboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String product_code;

	private String product_name;

	@JsonIgnoreProperties(value = { "product_lines", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductLine productLine;

	private String product_scale;

	private String product_vendor;

	@Column(length = 1000)
	private String product_description;

	private Long quantity_stock;

	private String buy_price;

	private String sell_price;

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public String getProduct_scale() {
		return product_scale;
	}

	public void setProduct_scale(String product_scale) {
		this.product_scale = product_scale;
	}

	public String getProduct_vendor() {
		return product_vendor;
	}

	public void setProduct_vendor(String product_vendor) {
		this.product_vendor = product_vendor;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public Long getQuantity_stock() {
		return quantity_stock;
	}

	public void setQuantity_stock(Long quantity_stock) {
		this.quantity_stock = quantity_stock;
	}

	public String getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}

	public String getSell_price() {
		return sell_price;
	}

	public void setSell_price(String sell_price) {
		this.sell_price = sell_price;
	}

	private static final long serialVersionUID = 1L;
}
