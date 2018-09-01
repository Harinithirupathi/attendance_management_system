package Employee.Dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import Employee.Dao.DetailsDao;
import Employee.util.DBUtil;

public class DetailsDaoImpl  implements DetailsDao{

	public DetailsDaoImpl(){
		
	}

	@Override
	public int insertDetails(List<String> EmployeeIdsList) {
		String sql = "insert into Details(employeeid,Name,Age,DOB,Address,Salary,Description,Email,Phone) values(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try{
		connection  = DBUtil.getConnection();
		connection.setAutoCommit(false);
		java.util.Date currentDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		for (String Employeeid : EmployeeIdsList) {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, Employeeid);
			prepareStatement.setString(2, Name);
			prepareStatement.setString(3, Age);
			prepareStatement.setString(4, DOB);
			prepareStatement.setString(5, Address);
			prepareStatement.setString(6, Salary);
			prepareStatement.setString(7, Description);
			prepareStatement.setString(8, Email);
			prepareStatement.setString(9, Phone);
			prepareStatement.executeUpdate();
		}
		connection.commit();
		}catch(Exception e){
			try{
				connection.rollback();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			DBUtil.close (connection, prepareStatement, null);
		
		}
		return EmployeeIdsList.size();
	}

	}
	
