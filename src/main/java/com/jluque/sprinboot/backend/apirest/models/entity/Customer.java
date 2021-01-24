package com.jluque.sprinboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String customer_name;

	private String contact_first_name;

	private String contact_last_name;

	private String phone;

	private String address_line_1;

	private String address_line_2;

	private String city;

	private String state;

	private String postal_code;

	private String country;

	private Long sales_representant_id;

	private Long credit_limit;

	@Temporal(TemporalType.DATE)
	private Date create_at;

	public Customer() {

	}

	@PrePersist
	public void prePersist() {
		this.create_at = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getContact_first_name() {
		return contact_first_name;
	}

	public void setContact_first_name(String contact_first_name) {
		this.contact_first_name = contact_first_name;
	}

	public String getContact_last_name() {
		return contact_last_name;
	}

	public void setContact_last_name(String contact_last_name) {
		this.contact_last_name = contact_last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress_line_1() {
		return address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getSales_representant_id() {
		return sales_representant_id;
	}

	public void setSales_representant_id(Long sales_representant_id) {
		this.sales_representant_id = sales_representant_id;
	}

	public Long getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(Long credit_limit) {
		this.credit_limit = credit_limit;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	private static final long serialVersionUID = 1L;
}
