<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1  style="color:midnightblue;"><b><center><em><marquee direction="right">Employee Data Input</marquee></em></center></b></h1>
</head>

<body style="background-color: #00cc99;">
<center style="color:lightcyan;">
<table style="background-color:#009999;" cellspacing="10" cellpadding="10" border="5">
</center>
<form method="get" action="fir">
<%
   Details<Employee> details = (Details<Employee>)request.getAttribute("EmployeeDetails");
   for(Employee employee : details){
	  out.println("<tr> <td> <b>"+student.getEmployeeid() +"</b></td> <td><b> "+Employee.getName()+ 
			  "</b></td> <td> <b><input type = 'checkbox' name='present' value='"+Employee.getEmployeeid()+"'></b></td></tr>");
   }
%>

</table>
<input type="submit" value="submit">
</form>
<td style="color:lightgreen;">
</body>
</html>