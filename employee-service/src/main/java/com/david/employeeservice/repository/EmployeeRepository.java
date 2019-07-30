package com.david.employeeservice.repository;

import java.util.List;

import org.bouncycastle.util.Iterable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.david.employeeservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where e.departmentId = :id")
	List<Employee> findByDepartmentId(@Param("id") Long id);
}
