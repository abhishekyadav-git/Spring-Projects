package com.abhishek.springbasics.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("java")
public final class JavaCourse implements IChooseSem_1_Optionals {

	private Logger logger = LoggerFactory.getLogger(JavaCourse.class);

	public JavaCourse() {
		logger.trace("JAvaCourseMaterial :: 0-param constructor");
	}

	@Override
	public String courseContent() {		
		logger.trace("JAvaCourseMaterial ::courseContent");
		return "1.oops ,2.Exception handling ,3. Collections and etc..";
	}

	@Override
	public int courseRating() {	
		logger.trace("Course Rating out of 5");
		return 4;
	}


}
