package Employee.web;


	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import Employee.business.EmployeeDetails;


	@WebServlet(name="savedetails",urlPatterns="/details")
	public class EmployeeSaveDetailsServlet extends HttpServlet {
		
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String s[] = req.getParameterValues("present");
			List<String> employeeIdList = new ArrayList<String>();
			for (String val : s) {
				System.out.println(val);
				employeeIdList.add(val);
			}
			EmployeeDetails details = new EmployeeDetails();
			details.putDetails(employeeIdList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/confirmattendance.jsp");
			dispatcher.forward(req, resp); 
		}

	}


