package com.abhishek.springbasics;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.abhishek.springbasics.School.SchoolPeriodGenerator;

@SpringBootApplication
public class SpringBoot1BasicsApplication {
	
	@Bean
	public Calendar createCalender() {
		return Calendar.getInstance();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBoot1BasicsApplication.class, args);
		
		SchoolPeriodGenerator schoolPer = ctx.getBean("schoolPeriod", SchoolPeriodGenerator.class);
		
		
		System.out.println(schoolPer.getWhichPeriodRunning("Vijay"));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
