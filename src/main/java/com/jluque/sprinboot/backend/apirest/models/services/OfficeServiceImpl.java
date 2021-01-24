package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.IOfficeDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Office;

@Service
public class OfficeServiceImpl implements IOfficeService{

	@Autowired
	private IOfficeDao officeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Office> findAll() {
		return officeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Office> findAll(Pageable pageable) {
		return officeDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Office save(Office office) {
		return officeDao.save(office);
	}

	@Override
	@Transactional
	public Office findById(Long id) {
		return officeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		officeDao.deleteById(id);
	}

}
