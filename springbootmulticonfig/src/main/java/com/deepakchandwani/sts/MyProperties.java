package com.deepakchandwani.sts;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data; 

 @Data
   public class MyProperties {	
 
	private String host;
	private int port;

}
