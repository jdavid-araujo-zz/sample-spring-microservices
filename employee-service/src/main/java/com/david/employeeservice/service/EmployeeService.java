package com.david.employeeservice.service;

import java.util.List;

import com.david.employeeservice.model.Employee;

public interface EmployeeService extends BaseService<Employee, Long> {

	List<Employee> findByDepartmentId(Long id);
}
