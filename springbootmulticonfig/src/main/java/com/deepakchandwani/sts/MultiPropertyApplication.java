package com.deepakchandwani.sts;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
 public class MultiPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPropertyApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(@Qualifier("my") MyProperties myProperties,
			@Qualifier("some") MyProperties someProperties) {
		return args -> {
			System.out.println(myProperties);
			System.out.println(someProperties);
		};
	}

	@Bean(name = "my")
	@ConfigurationProperties("my-prop")
	public MyProperties myProperties() {
		return new MyProperties();
	}

	@Bean(name = "some")
	@ConfigurationProperties("some-prop")
	public MyProperties someProperties() {
		return new MyProperties();
	}

}
