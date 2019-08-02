package com.david.departmentservice.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.departmentservice.client.EmployeeFeignClient;
import com.david.departmentservice.model.Department;
import com.david.departmentservice.model.Employee;
import com.david.departmentservice.service.DepartmentService;

@RequestMapping(value = "/v1/departments")
@RestController
public class DepartmentServiceResource implements Serializable {

	private static final long serialVersionUID = 7153345573891339447L;
	
	private DepartmentService departmentService;
	
	
	@Autowired
	public DepartmentServiceResource(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping
	public void save(@RequestBody Department entity) {
		this.departmentService.save(entity);
	}	
	
	@GetMapping(value = "/{id}/with-employees")
	public ResponseEntity<Department> findDepartmentWithEmployees(@PathVariable(value = "id", required = true) Long id) {
		Department department = this.departmentService.findById(id);
		
		Set<Employee> employees =  this.departmentService.findByDepartmentId(id);
		
		department.setEmployees(employees);
		
		return ResponseEntity.ok(department);
	}
}
