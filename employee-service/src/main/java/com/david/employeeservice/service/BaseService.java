package com.david.employeeservice.service;

public interface BaseService<T, ID> {
	void save(T entity);
	
	void update(ID id, T entity);
	
	T findById(ID id);
	
	Iterable<T> findAll();
	
	void deleteById(ID id);
}
