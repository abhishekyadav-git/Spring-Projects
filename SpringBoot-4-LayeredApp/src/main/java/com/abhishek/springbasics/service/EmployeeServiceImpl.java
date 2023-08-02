package com.abhishek.springbasics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.springbasics.dao.IEmployeeDao;
import com.abhishek.springbasics.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao empDao;

	@Override
	public List<Employee> getResourcesByDesg(String desg1, String desg2, String desg3) throws Exception {		
		return empDao.getResourcesByDesg(desg1, desg2, desg3);
	}

}
