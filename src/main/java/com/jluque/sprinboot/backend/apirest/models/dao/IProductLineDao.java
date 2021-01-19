package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.ProductLine;

public interface IProductLineDao extends JpaRepository<ProductLine, Long> {

}
