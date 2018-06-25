package com.deepakchandwani.spring.di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepakchandwani.spring.di.configuration.DIConfiguration;
import com.deepakchandwani.spring.di.consumer.MyApplication;

public class ClientApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		
		app.processMessage("Hi Deepak", "deepakchandwani@yahoo.com");
		
		//close the context
		context.close();
	}

}
