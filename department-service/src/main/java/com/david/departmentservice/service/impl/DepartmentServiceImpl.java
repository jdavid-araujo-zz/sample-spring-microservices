package com.david.departmentservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.departmentservice.client.EmployeeFeignClient;
import com.david.departmentservice.exceptiohandler.exception.DepartmentNotFoundException;
import com.david.departmentservice.model.Department;
import com.david.departmentservice.model.Employee;
import com.david.departmentservice.repository.DepartmentRepository;
import com.david.departmentservice.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	private EmployeeFeignClient employeeFeignClient;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository,
								 EmployeeFeignClient employeeFeignClient) {
		this.departmentRepository = departmentRepository;
		this.employeeFeignClient = employeeFeignClient;
	}
	
	@Override
	public void save(Department entity) {
		this.departmentRepository.save(entity);
	}

	@Override
	public void update(Long id, Department entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Long id) {
		Optional<Department> entity = this.departmentRepository.findById(id);

		return entity.orElseThrow(() -> new DepartmentNotFoundException());
	}

	@Override
	public Iterable<Department> findAll() {
		return this.departmentRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.departmentRepository.deleteById(id);
	}
	
	private List<Employee> fallbackEmplyeeList()
	{
		return null;
	}
	
	@HystrixCommand(
			fallbackMethod = "fallbackEmplyeeList",
			threadPoolKey = "employeeByDepartmentThreadPool",
			threadPoolProperties = 
			{
				@HystrixProperty(name = "coreSize", value = "30"),
				@HystrixProperty(name = "maxQueueSize", value = "10")					
			},
		    commandProperties = 
			{
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="80"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
                    @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")
            }
			)
	@Override
	public Set<Employee> findByDepartmentId(Long id) {
		return this.employeeFeignClient.findByDepartmentId(id);
	}

}
