package Employee.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Employee.bean.Employee;
import Employee.business.EmployeeDetails;
@WebServlet(name="details",urlPatterns="/list")
public class EmployeeDetailsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EmployeeDetails details = new EmployeeDetails();
	List<Employee> employeeList = details.getEmployees();
	req.setAttribute("emplist", employeeList);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/list.jsp");
	dispatcher.forward(req, resp);
}

}

