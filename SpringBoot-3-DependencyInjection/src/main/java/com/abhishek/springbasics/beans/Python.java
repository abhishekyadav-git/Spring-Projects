package com.abhishek.springbasics.beans;

import org.springframework.stereotype.Component;

@Component("python")
public final class Python implements IChooseSem_1_Optionals {

	@Override
	public String courseContent() {		
		return "1.Python Lang Fundamentals ,2.Oops ,3. Exceptional Handling and etc..";
	}

	@Override
	public int courseRating() {		
		return 4;
	}

}
