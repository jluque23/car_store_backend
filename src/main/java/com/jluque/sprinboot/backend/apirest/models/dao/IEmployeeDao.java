package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long>{

}
