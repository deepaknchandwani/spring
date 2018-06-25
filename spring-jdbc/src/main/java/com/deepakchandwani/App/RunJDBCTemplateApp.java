package com.deepakchandwani.App;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepakchandwani.dao.JDBCEmployeeDAO;
import com.deepakchandwani.entity.Employee;

 
public class RunJDBCTemplateApp {

	public static void main(String[] args) {
	
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        
	        JDBCEmployeeDAO jdbcEmployeeDAO = (JDBCEmployeeDAO) context.getBean("jdbcEmployeeDAO");
	        Employee employee3 = new Employee(456, "AnandShah", 34);
	        //jdbcEmployeeDAO.insert(employee3);
	 
	        Employee employee4 = jdbcEmployeeDAO.findById(456);
	        System.out.println(employee4);	
	        
	        List<Employee> employees = jdbcEmployeeDAO.findAll();
	        System.out.println(employees);	

	        String name = jdbcEmployeeDAO.findNameById(456);
	        System.out.println(name);
	        
			context.close();
	}
}
