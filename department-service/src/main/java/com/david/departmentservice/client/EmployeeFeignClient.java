package com.david.departmentservice.client;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.david.departmentservice.model.Employee;

@FeignClient("employeeservice")
public interface EmployeeFeignClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/employees/departments/{id}",
            consumes="application/json")
    Set<Employee> findByDepartmentId(@PathVariable("id") Long id);
}
