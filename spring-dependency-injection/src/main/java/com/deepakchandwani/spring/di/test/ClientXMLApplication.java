package com.deepakchandwani.spring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deepakchandwani.spring.di.consumer.MyXMLApplication;

public class ClientXMLApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MyXMLApplication app = context.getBean(MyXMLApplication.class);

		app.processMessage("Hi Deepak", "deepakchandwani@yahoo.com");

		// close the context
		context.close();
	}

}
