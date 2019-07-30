package com.david.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.departmentservice.model.Department;
import com.david.departmentservice.repository.DepartmentRepository;
import com.david.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public void save(Department entity) {
		this.save(entity);
	}

	@Override
	public void update(Long id, Department entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Department> findAll() {
		return this.departmentRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.departmentRepository.deleteById(id);
	}

}
