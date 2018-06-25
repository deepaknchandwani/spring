package com.deepakchandwani.App;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepakchandwani.dao.EmployeeDAO;
import com.deepakchandwani.entity.Employee;

public class RunApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee1 = new Employee(123, "DeepakNChandwani", 30);
	//	employeeDAO.insert(employee1); 
		Employee employee2 = employeeDAO.findById(123);
		System.out.println(employee2);
		context.close();
	}
}
