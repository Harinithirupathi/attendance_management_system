package Employee.Dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Employee.bean.Employee;
import Employee.Dao.EmployeeDao;
import Employee.util.DBUtil;
import Employee.bean.Employee;
import Employee.Dao.impl.EmployeeDaoImpl;

public class EmployeeDaoImpl implements EmployeeDao{

	public EmployeeDaoImpl(){
		
	}

	@Override
	public List<Employee> getEmployees() {
		
			List<Employee> EmployeeList = new ArrayList<Employee>();
			String sql = "select * from Employee";
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			ResultSet resultSet = null;
			try {
				connection = DBUtil.getConnection();
				prepareStatement = connection.prepareStatement(sql);
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()){
					Employee employee = new Employee();
					employee.setEmployeeid(resultSet.getString("Employeeid"));
					employee.setName(resultSet.getString("Name"));
					employee.setAge(resultSet.getString("Age"));
					employee.setDOB(resultSet.getString("DOB"));
					employee.setAddress(resultSet.getString("Address"));
					employee.setSalary(resultSet.getString("Salary"));
					employee.setDescription(resultSet.getString("Description"));
					employee.setEmail(resultSet.getString("Emali"));
					employee.setPhone(resultSet.getString("phone"));
					employeeList.add(employee);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(connection, prepareStatement, resultSet);
			}
			return EmployeeList;
		}	
		
		public void inserData(String fileName){
			List<String> list = readReader(fileName);
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			
			try {
			for (String line : list) {
				String employeeElements[] = line.split(",");
				System.out.println(employeeElements[0]);
				String sql = "insert into employee values(?,?,?,?)";
					connection = DBUtil.getConnection();
					prepareStatement = connection.prepareStatement(sql);
					prepareStatement.setString(1,employeeElements[0]);
					prepareStatement.setString(2, employeeElements[1]);
					prepareStatement.setString(3, employeeElements[2]);
					prepareStatement.setString(4, employeeElements[3]);
					prepareStatement.setString(5,employeeElements[4]);
					prepareStatement.setString(6, employeeElements[5]);
					prepareStatement.setString(7, employeeElements[6]);
					prepareStatement.setString(8, employeeElements[7]);
					
					prepareStatement.executeUpdate();
			}
			} catch (Exception e) {
					e.printStackTrace();
			}finally {
					DBUtil.close(connection, prepareStatement,null);
			}
				
			
		}
		
		public List<String> readReader(String fileName){
			BufferedReader bufferReader = null; // declare
			 List<String> list = new ArrayList<String>();
			 String tmp = "";
			try{
				bufferReader = new BufferedReader(
					new FileReader(fileName)); //initialize
			
			 while((tmp = bufferReader.readLine()) != null){
				 list.add(tmp);
			 }
			 System.out.println(list);
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(bufferReader != null)
						bufferReader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return list;
		}
		
		public static void main(String[] args) {
			EmployeeDaoImpl impl = new EmployeeDaoImpl();
			impl.inserData("D:\\project\\prp1.csv");
		}
	}
	