<%@page import="Dto.Patient"%>
<%@page import="Dao.My_Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Patirnt</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		My_Dao dao = new My_Dao();
		Patient patient = dao.fetchPatient(id);
		if (patient == null) {
			response.getWriter().print("<h1>Enter Valid id</h1>");
			request.getRequestDispatcher("Enter_Patient_Id.html").include(request, response);
		} else {
	%>

	<form action="Update_Patient" method="post">
		<table>
			<tr>
				<th><label for="id">Id :</label></th>
				<th><input type="text" name="id" value="<%=patient.getId()%>"
					readonly="readonly"></th>
			</tr>
			<tr>
				<th><label for="name">Name :</label></th>
				<th><input type="text" name="name"
					value="<%=patient.getName()%>"></th>
			</tr>

			<tr>
				<th><label for="mobile">Mobile :</label></th>
				<th><input type="text" name="mobile"
					value="<%=patient.getMobile()%>" readonly="readonly"></th>
			</tr>

			<tr>
				<th><label for="dob">Date of Birth :</label></th>
				<th><input type="date" name="dob" value="<%=patient.getDob()%>">
				</th>
			</tr>

			<tr>
				<th>
					<button>Update</button>
				</th>
				<th>
					<button type="reset">Cancel</button>
				</th>
			</tr>



		</table>
	</form>

	<br>
	<a href="Enter_Patient_Id.html"><button>Back</button></a>
	<%
		}
	%>
</body>
</html>