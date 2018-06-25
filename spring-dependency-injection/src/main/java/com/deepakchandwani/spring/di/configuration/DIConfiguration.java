package com.deepakchandwani.spring.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.deepakchandwani.spring.di.services.EmailService;
import com.deepakchandwani.spring.di.services.MessageService;

@Configuration
@ComponentScan(value={"com.deepakchandwani.spring.di.consumer"})
public class DIConfiguration {

	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}
