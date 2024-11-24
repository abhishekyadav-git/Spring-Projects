package com.example.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
	private Logger log = Logger.getLogger(SecurityAspect.class.getName());
	
	@Around("@annotation(com.example.demo.custom_annotation.LogAnnotation.ToLog)")
	public String log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// get Intercepted method Name
		String methodName = joinPoint.getSignature().getName();
		
		// get Intercepted method passed arguments
		
		Object [] args = joinPoint.getArgs();
		
		log.info("Security Aspect here"+ "\n");
		
		// call the intercepted method
		
		// create new args
		
		Comment comm = new Comment();
		comm.setText("Updated Comment");
		Object[] newArgs = {comm};
		
		Object returnedValue = joinPoint.proceed(newArgs);
		
		log.info("Intercepted method returned value while returning from security aspect = " +returnedValue);
		
		return "UPDATE";
		
	}
}
