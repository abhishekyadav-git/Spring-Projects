package com.abhishek.springbasics;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.abhishek.springbasics.dao.EmployeeDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//to exclude the classes getting autoconfigured by spring 
public class SpringBoot2AutoConfigurationApplication {
	
	// if we dont want spring given datasources we can configure by ourselves and marked method as @Bean
	
	@Bean
	public DataSource createDataSource() throws Exception {
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setJdbcUrl("jdbc:mysql://localhost:3307/realtime_di");
		cds.setUser("root");
		cds.setPassword("root");
		cds.setDriverClass("com.mysql.cj.jdbc.Driver");
		return cds;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBoot2AutoConfigurationApplication.class, args);
		
		EmployeeDao emp = ctx.getBean("employeeDao", EmployeeDao.class);
		
		try {
			System.out.println("Employee Count = " + emp.getEmployeeCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
