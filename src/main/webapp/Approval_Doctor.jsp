<%@page import="Dto.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Doctor</title>
</head>
<body>
<%
		List<Doctor> list = (List<Doctor>) request.getAttribute("list");
	%>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Age</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
			for (Doctor doctor : list) {
		%>
		<tr>
			<th><%=doctor.getId()%></th>
			<th><%=doctor.getName()%></th>
			<th><%=doctor.getMobile()%></th>
			<th><%=doctor.getAge()%></th>
			<th><%=doctor.isStatus()%></th>
			<th><a href="Change_Doctor_Status?id=<%=doctor.getId()%>"><button>Change</button></a></th>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>