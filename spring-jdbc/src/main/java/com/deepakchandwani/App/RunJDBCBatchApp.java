package com.deepakchandwani.App;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepakchandwani.dao.JDBCEmployeeDAO;
import com.deepakchandwani.entity.Employee;



public class RunJDBCBatchApp {

	public static void main(String[] args) {
	
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	        JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context.getBean("jdbcEmployeeDAO");
	        
	        Employee emplNew1 = new Employee(23, "Manoj", 23);
	        Employee emplNew2 = new Employee(223, "Ramesh", 43);
	        List<Employee> employeesN = new ArrayList();
	        employeesN.add(emplNew1);
	        employeesN.add(emplNew2);
	        //jdbcEmployeeDAO.insertBatch1(employeesN);
	        System.out.println(" inserted rows: " + employeesN);

	        System.out.println(" FindAll : " + jdbcEmployeeDAO.findAll());
	        jdbcEmployeeDAO.insertBatch2("UPDATE Employee SET NAME ='John Lee'");
	        
	        List<Employee> employees = jdbcEmployeeDAO.findAll();
	        System.out.println("Updated column name of table: " + employees);	
	        
	        System.out.println(" FindAll : " + jdbcEmployeeDAO.findAll());
			context.close();
	}
}
