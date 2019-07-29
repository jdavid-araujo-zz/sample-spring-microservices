package com.david.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
