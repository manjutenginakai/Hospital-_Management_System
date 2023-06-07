<%@page import="Dto.Staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve_Staff</title>
</head>
<body>
	<%
		List<Staff> list = (List<Staff>) request.getAttribute("list");
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
			for (Staff staff : list) {
		%>
		<tr>
			<th><%=staff.getId()%></th>
			<th><%=staff.getName()%></th>
			<th><%=staff.getMobile()%></th>
			<th><%=staff.getAge()%></th>
			<th><%=staff.isStatus()%></th>
			<th><a href="Change_Staff_Status?id=<%=staff.getId()%>"><button>Change</button></a></th>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>