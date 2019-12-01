package com.deepakchandwani.sts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
 
	
	 @Autowired
	 @Qualifier("jdbcTemplate1")
	 private JdbcTemplate jdbcTemplate1;
	 
	 @Autowired
	 @Qualifier("jdbcTemplate2")
	 private JdbcTemplate jdbcTemplate2;

	@Override
	public void run(String... strings) throws Exception {

		log.info("Creating tables");

		jdbcTemplate1.execute("DROP TABLE customers ");
		jdbcTemplate1.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		// Split up the array of whole names into an array of first/last names

		List<Object[]> splitUpNames =

				Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()

						.map(name -> name.split(" ")).collect(Collectors.toList());

		// Use a Java 8 stream to print out each tuple of the list
		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate1.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

		log.info("Querying for customer records where first_name = 'Josh':");

		jdbcTemplate1
				.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
						(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"),
								rs.getString("last_name")))

				.forEach(customer -> log.info(customer.toString()));

		String sql = "select count(*) from customers";
		int countOfCustomers = jdbcTemplate2.queryForObject(sql, Integer.class);
		System.out.println(countOfCustomers);

	}

		
	  @Bean(name = "db1")
	  
	  @ConfigurationProperties(prefix = "spring.datasource") public DataSource
	  dataSource1() { return DataSourceBuilder.create().build(); }
	  
	  @Bean(name = "jdbcTemplate1") public JdbcTemplate
	  jdbcTemplate1(@Qualifier("db1") DataSource ds) { return new JdbcTemplate(ds);
	  }
	  
	  @Bean(name = "db2")
	  
	  @ConfigurationProperties(prefix = "oracle.datasource") public DataSource
	  dataSource2() { return DataSourceBuilder.create().build(); }
	  
	  @Bean(name = "jdbcTemplate2") public JdbcTemplate
	  jdbcTemplate2(@Qualifier("db2") DataSource ds) { return new JdbcTemplate(ds);
	  }
	 
}
