package com.example.demo.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CommentAspect {
	private Logger log = Logger.getLogger(CommentAspect.class.getName());
	
	@Around("@annotation(com.example.demo.custom_annotation.LogAnnotation.ToLog)")
	public String log(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// get Intercepted method Name
		String methodName = joinPoint.getSignature().getName();
		
		// get Intercepted method passed arguments
		
		Object [] args = joinPoint.getArgs();
		
		log.info("Method Name = " + methodName + "\n" + "Actual Passed Arguments = " + Arrays.asList(args) + "\n");
		
		// call the intercepted method
		
		Object returnedValue = joinPoint.proceed();
		
		log.info("Intercepted method returned value = " +returnedValue);
		
		return (String) returnedValue == "UPDATE" ? "FALSE" : (String)returnedValue;
		
	}
}
