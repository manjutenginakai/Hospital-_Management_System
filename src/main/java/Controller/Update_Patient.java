package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Patient;
@WebServlet("/Update_Patient")
public class Update_Patient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();

		My_Dao dao = new My_Dao();

		Patient patient = dao.fetchPatient(id);
		
			patient.setAge(age);
			patient.setDob(dob);
			patient.setName(name);

			dao.update(patient);

			resp.getWriter().print("<h1 style='color:green'>Patient Data Updated Successfully</h1>");
			req.getRequestDispatcher("Staff_Home.html").include(req, resp);
		
	}
}
