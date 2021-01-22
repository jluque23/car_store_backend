package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Office;

public interface IOfficeDao extends JpaRepository<Office, Long>{

}
