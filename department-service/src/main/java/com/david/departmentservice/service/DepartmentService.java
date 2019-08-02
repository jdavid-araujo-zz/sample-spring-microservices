package com.david.departmentservice.service;

import java.util.List;
import java.util.Set;

import com.david.departmentservice.model.Department;
import com.david.departmentservice.model.Employee;

public interface DepartmentService extends BaseService<Department, Long> {
	
	Set<Employee> findByDepartmentId(Long id);
}
