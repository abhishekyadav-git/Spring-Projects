package com.abhishek.springbasics.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("stu")
public class CollegeStudent {
	
	private Logger logger = LoggerFactory.getLogger(CollegeStudent.class);
	
	@Autowired
	@Qualifier("python")
	private IChooseSem_1_Optionals optionals;
	
	public void printSem1OptionalDetails(String examName) {
		logger.trace("start of method printSem1OptionalDetails(-)");
		System.out.println("preparation started for  "+examName);
		String courseContent =optionals.courseContent();
		logger.info("course content is fetched");
		int rating = optionals.courseRating();
		logger.info("course rating fetched");
		logger.debug("Dependent obj services are used");
		System.out.println("Student has choosen "+courseContent+" with rating of ::"+rating);
		System.out.println("preparation is completed for "+examName);
		logger.trace("end of method ;; printSem1OptionalDetails(-)");
	}
}
