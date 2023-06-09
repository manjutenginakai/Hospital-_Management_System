package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.My_Dao;
import Dto.Patient;

@WebServlet("/AddPatient")
@MultipartConfig
public class Add_Patient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date Dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(Dob.toLocalDate(), LocalDate.now()).getYears();
		Part picture = req.getPart("picture");
		byte[] image = new byte[picture.getInputStream().available()];
		picture.getInputStream().read(image);

		My_Dao dao = new My_Dao();
		
		Patient patient1=dao.fetchPatient(mobile);
		if(patient1==null)
		{
		Patient patient = new Patient();
		patient.setName(name);
		patient.setAge(age);
		patient.setDob(Dob);
		patient.setMobile(mobile);
		patient.setPicture(image);

	
		dao.savePatient(patient);

		resp.getWriter().print("<h1 style='color:green'>Patient Data Added Successfully</h1>");
		req.getRequestDispatcher("Staff_Home.html").include(req, resp);
	}
		else{
			resp.getWriter().print("<h1 style='color:red'>Mobile number already exist</h1>");
			req.getRequestDispatcher("Staff_Home.html").include(req, resp);
		}
	}
}
