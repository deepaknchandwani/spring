package com.deepakchandwani.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.deepakchandwani.dao.EmployeeDAO;
import com.deepakchandwani.entity.Employee;

 

public class EmployeeDAOImpl implements EmployeeDAO
{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Employee employee){
 
		String sql = "INSERT INTO Employee " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getCUST_ID());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getAge());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public Employee findById(int id){
 
		String sql = "SELECT * FROM Employee WHERE CUST_ID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Employee employee = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("AGE")
				);
			}
			rs.close();
			ps.close();
			return employee;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}