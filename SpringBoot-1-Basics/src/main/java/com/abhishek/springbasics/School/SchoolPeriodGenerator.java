package com.abhishek.springbasics.School;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "schoolPeriod")
public class SchoolPeriodGenerator {
	
	@Autowired
	private Calendar cal;
	
	public SchoolPeriodGenerator() {
		System.out.println("Inside School Period Gen class constructor");
	}
	
	public String getWhichPeriodRunning(String parentName) {
		
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		
		String whichPeriod = "";
		
		if(hr > 8 && hr <= 9) {
			whichPeriod = " Assembly Time";
		}
		else if(hr > 9 && hr<= 10) {
			whichPeriod = " 1st Period";
		}
		else if(hr > 10 && hr<= 11) {
			whichPeriod = " 2nd Period";
		}
		else if(hr > 11 && hr<= 12) {
			whichPeriod = " 3rd Period";
		}
		else if(hr > 12 && hr<= 13) {
			whichPeriod = " Lunch Break";
		}
		else if(hr > 13 && hr<= 14) {
			whichPeriod = " 4th Period";
		}
		else if(hr > 14 && hr<= 15) {
			whichPeriod = " 5th Period";
		}
		else if(hr > 15) {
			whichPeriod = "School Closed";
		}
		
		return whichPeriod.equals("School Closed") ? "Mr. " + parentName + " School is Closed" : "Mr. " + parentName + whichPeriod + " is going on currently";
	}
}
