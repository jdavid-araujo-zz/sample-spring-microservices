package com.david.employeeservice.resource;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.employeeservice.model.Employee;
import com.david.employeeservice.service.EmployeeService;

@RequestMapping(value = "/v1/employees")
@RestController
public class EmployeeServiceResource implements Serializable{

	private static final long serialVersionUID = -4328188252740239010L;

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeServiceResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public void save(@RequestBody Employee entity) {
		this.employeeService.save(entity);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@PutMapping("/{id}")
	public void update(@PathVariable(value = "id", required = true) Long id,
						@RequestBody Employee entity) {
		this.employeeService.update(id, entity);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Employee>> findAll() {
		Iterable<Employee> body = this.employeeService.findAll();
		
		return ResponseEntity.ok(body);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable(value = "id", required = true) Long id) {
		Employee body = this.employeeService.findById(id);
		
		return ResponseEntity.ok(body);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable(value = "id", required = true) Long id) {
		this.employeeService.deleteById(id);
	}

}
