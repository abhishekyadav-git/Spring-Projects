package com.abhishek.springbasics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhishek.springbasics.model.Employee;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
	private static final String GET_EMP_BY_DESG = "SELECT ENO, ENAME, DESG, GROSSSALARY FROM EMPLOYEE WHERE DESG IN (?,?,?)";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getResourcesByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		
		List<Employee> resList = null;
		
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(GET_EMP_BY_DESG)){
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			try(ResultSet rs = ps.executeQuery()){
				resList = new ArrayList<>();
				while(rs.next()) {
					Employee e = new Employee();
					e.setEno(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setDesg(rs.getString(3));
					e.setGrossSalary(rs.getFloat(4));
					resList.add(e);
				}
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // rethrow exception
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; // rethrow exception
		}
		
		
		return resList;
	}
	
}	