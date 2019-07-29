package com.david.employeeservice.service.impl;

import org.springframework.stereotype.Service;

import com.david.employeeservice.model.Employee;
import com.david.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeService employeeService;
	
	@Override
	public void save(Employee entity) {
		this.employeeService.save(entity);
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
		return this.employeeService.findAll();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
