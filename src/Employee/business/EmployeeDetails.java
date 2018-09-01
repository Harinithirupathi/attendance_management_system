package Employee.business;
import java.util.List;
import Employee.bean.Employee;
import Employee.Dao.DetailsDao;
import Employee.Dao.EmployeeDao;
import Employee.Dao.impl.DetailsDaoImpl;
import Employee.Dao.impl.EmployeeDaoImpl;

public class EmployeeDetails {
	
	EmployeeDao employeeDao;
	DetailsDao detailsDao;
	public EmployeeDetails(){
		employeeDao = new EmployeeDaoImpl();
		detailsDao = new DetailsDaoImpl();
	}
	
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}
	public int putDetails(List<String> employeeIdList){
		return detailsDao.insertDetails(employeeIdList);
	}
}