package com.deepakchandwani.dao;

import java.util.List;

import com.deepakchandwani.entity.Employee;

public interface JDBCEmployeeDAO {
	
	public void insert(Employee employee);

	 public Employee findById(int id);

	 public List<Employee> findAll();
	 
	 public String findNameById(int id);
	 
	 public void insertBatch1(final List<Employee> employees);
	 
	 public void insertBatch2(final String sql);


}
