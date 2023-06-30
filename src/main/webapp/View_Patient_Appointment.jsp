<%@page import="Dto.Patient"%>
<%@page import="java.util.List"%>
<%@page import="Dao.My_Dao"%>
<%@page import="Dto.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patient Appointment</title>
</head>
<body>
	<%
		int pid = Integer.parseInt(request.getParameter("id"));
		My_Dao dao = new My_Dao();
		Patient patient = dao.fetchPatient(pid);
		System.out.println(patient);
		List<Appointment> list = patient.getAppointment();
		if (list==null || list.isEmpty()) {
			response.getWriter().print("<h1 style='color:red'>No Apppoinments Yet</h1>");
			request.setAttribute("list", dao.fetchAllPatient());
			request.getRequestDispatcher("View_Patient_History.jsp").include(request, response);
		} else {
	%>

	<h1>Appointment Details</h1>
	<table border="1">
		<tr>
			<th>Appointment Id</th>
			<th>Patient</th>
			<th>Problem</th>
			<th>Doctor</th>
			<th>Appointment Date</th>
		</tr>
		<%
			for (Appointment appointment : list) {
		%>
		<tr>
			<th><%=appointment.getId()%></th>
			<th><%=appointment.getPatient().getName()%></th>
			<th><%=appointment.getProblem()%></th>
			<th><%=appointment.getDoctor().getName()%></th>
			<th>
				<%
					if (appointment.getTime() == null) {
				%> Not Yet Visited Doctor <%
					} else {
				%>
				<%=appointment.getTime()%> <%
 	}
 %>
			</th>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<%
		if (session.getAttribute("admin") != null) {
	%>
	<a href="Admin_Fetch_All_Patient"><button>Back</button></a>
	<%
		} else {
	%>
	<a href="Staff_Fetch_Patient_History"><button>Back</button></a>
	<%
		}
		}
	%>
</body>
</html>