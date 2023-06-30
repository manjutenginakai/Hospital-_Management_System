<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View patient history</title>
</head>
<body>
<body>
<%
		List<Patient> list = (List<Patient>) request.getAttribute("list");
%> 
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Age</th>
			<th>Picture</th>
			<th>View Previous Appointments</th>
		</tr>
		<%
			for (Patient patient : list) {
		%>
		<tr>
			<th><%=patient.getId()%></th>
			<th><%=patient.getName()%></th>
			<th><%=patient.getMobile()%></th>
			<th><%=patient.getAge()%></th>
			<th>
			<%
			String base64=Base64.encodeBase64String(patient.getPicture());
			%>
			<img height="100px" width="100px" alt="unknown" src="data:image/jpeg;base64,<%=base64%>">
			</th>
			<th><a href="View_Patient_Appointment.jsp?id=<%=patient.getId()%>"><button>Click</button></a></th>
		</tr>
		<%
			}
		%>
	</table>
	<a href="Admin_Home.html"><button>Back</button></a>


</body>
</html>