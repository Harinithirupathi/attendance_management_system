package Employee.util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class DBUtil {

		
		public static Connection getConnection(){
			Connection connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/Employee","root","root");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
		
			}
		


