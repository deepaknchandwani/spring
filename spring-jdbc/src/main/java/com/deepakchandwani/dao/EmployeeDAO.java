package com.deepakchandwani.dao;

import com.deepakchandwani.entity.Employee;

public interface EmployeeDAO {

	public void insert(Employee employee);
	public Employee findById(int id);
}