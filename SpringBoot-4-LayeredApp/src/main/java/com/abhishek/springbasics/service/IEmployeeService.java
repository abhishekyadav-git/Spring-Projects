package com.abhishek.springbasics.service;

import java.util.List;

import com.abhishek.springbasics.model.Employee;

public interface IEmployeeService {
	public List<Employee> getResourcesByDesg(String desg1, String desg2, String desg3) throws Exception;
}
