package com.abhishek.springbasics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.abhishek.springbasics.model.Employee;
import com.abhishek.springbasics.service.IEmployeeService;

@Controller("empController")
public class WageSystemController {
	
	@Autowired
	private IEmployeeService service;
	
	public List<Employee> getResourcesByDesg(String desg1, String desg2, String desg3) throws Exception {		
		return service.getResourcesByDesg(desg1, desg2, desg3);
	}
}
