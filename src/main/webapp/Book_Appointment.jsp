<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Appointment</title>
</head>
<body>
	<%
		if (session.getAttribute("staff") == null) {
			response.getWriter().print("<h1 style=color:red>Session Expired");
			request.getRequestDispatcher("Login.html").include(request, response);
		} else {
	%>
	<a href="Fetch_All_Patient"><button>View All Patient</button></a>
	<br><br>
	<a href="Fetch_By_Id.html"><button>Fetch Patient By Id</button></a>
	<%
		}
	%>
<br><br>
<a href="Staff_Home.html"><button>Back</button></a>


</body>
</html>