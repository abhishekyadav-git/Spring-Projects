package com.abhishek.springbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.abhishek.springbasics.beans.CollegeStudent;

@SpringBootApplication
public class SpringBoot3DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBoot3DependencyInjectionApplication.class, args);
		
		CollegeStudent stuObj = ctx.getBean("stu",CollegeStudent.class);
		
		stuObj.printSem1OptionalDetails("Sem1 Finals");
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
