package com.deepakchandwani.roemapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.deepakchandwani.entity.Employee;

@SuppressWarnings("rawtypes")
public class EmployeeRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setCUST_ID(rs.getInt("CUST_ID"));
		employee.setName(rs.getString("NAME"));
		employee.setAge(rs.getInt("AGE"));
		return employee;
	}

}