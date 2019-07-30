package com.david.employeeservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.employeeservice.exceptionhandler.exception.EmployeeNotFoundException;
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
		Employee employee = this.findById(id);

		BeanUtils.copyProperties(entity, employee, "id");

		this.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> entity = this.employeeRepository.findById(id);

		return entity.orElseThrow(() -> new EmployeeNotFoundException());
	}

	@Override
	public Iterable<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByDepartmentId(Long id) {
		return this.employeeRepository.findByDepartmentId(id);
	}

}
