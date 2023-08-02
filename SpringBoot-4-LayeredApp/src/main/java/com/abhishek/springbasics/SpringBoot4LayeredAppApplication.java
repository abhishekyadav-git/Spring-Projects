package com.abhishek.springbasics;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.abhishek.springbasics.controller.WageSystemController;
import com.abhishek.springbasics.model.Employee;

@SpringBootApplication
public class SpringBoot4LayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBoot4LayeredAppApplication.class, args);
		
		WageSystemController wsc = ctx.getBean("empController", WageSystemController.class);
		
		String desg1,desg2,desg3 = "";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desg1 = ");
		desg1 = sc.next();
		System.out.println("Enter desg2 = ");
		desg2 = sc.next();
		System.out.println("Enter desg3 = ");
		desg3 = sc.next();
		
		List<Employee> empList;
		try {
			empList = wsc.getResourcesByDesg(desg1, desg2, desg3);
			for(Employee e : empList) {
				System.out.println(e);
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
		((ConfigurableApplicationContext) ctx).close();	
		
	}

}
