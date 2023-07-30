package com.abhishek.springbasics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	private static final String GET_EMP_COUNT = "select count(*) from employee";
	
	@Autowired
	private DataSource ds; 
	
	public int getEmployeeCount() throws Exception {
		int count = 0;
		
		// get pooled conn jdbc obj
		
		Connection con = ds.getConnection();
		
		// Create prepared statement
		
		PreparedStatement ps = con.prepareStatement(GET_EMP_COUNT);
		
		// execute the query
		
		ResultSet rs = ps.executeQuery(GET_EMP_COUNT);
		
		// process the resultset
		
		rs.next();
		
		count = rs.getInt(1);
		
		rs.close();
		ps.close();
		con.close();
		
		return count;
	}
}
