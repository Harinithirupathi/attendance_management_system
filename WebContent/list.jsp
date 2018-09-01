<%@ page language="java" import="edu.ksr.iet.prp.bean.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1  style="color:midnightblue;"><b><center><em><marquee direction="right">PRP StudentList</marquee></em></center></b></h1>
<hr>
</head>
<body style="background-color: #00cc99;">
<center style="color:lightcyan;">
<table style="background-color:#009999;" cellspacing="10" cellpadding="10" border="5">
</center>
<form method="post" action="attn">
<%
   List<Student> list = (List<Student>)request.getAttribute("stulist");
   for(Student student : list){
	  out.println("<tr> <td> <b>"+student.getStudentid() +"</b></td> <td><b> "+student.getName()+ 
			  "</b></td> <td> <b><input type = 'checkbox' name='present' value='"+student.getStudentid()+"'></b></td></tr>");
   }
%>

</table>
<input type="submit" value="Put Attendance">
</form>
<td style="color:lightgreen;">
</body>
</html>