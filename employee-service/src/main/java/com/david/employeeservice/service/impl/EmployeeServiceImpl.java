package com.david.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.employeeservice.model.Employee;
import com.david.employeeservice.repository.EmployeeRepository;
import com.david.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public void save(Employee entity) {
		this.employeeRepository.save(entity);
	}

	@Override
	public void update(Long id, Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.employeeRepository.deleteById(id);
	}

}
