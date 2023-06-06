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
import Dto.Staff;

@WebServlet("/staff_signup")
public class Staff_Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		My_Dao dao=new My_Dao();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");

	      //int age = LocalDate.now().getYear() - dob.toLocalDate().getYear();
		// When we want approximate age that time we will go for this method
		// LocalDate.now().getYear()-->This is indicates present date or year.
		// dob.toLocalDate().getYear()-->This is indicates date of birth date or year.

		 int age = Period.between(dob.toLocalDate(),LocalDate.now()).getYears();
		// When we want exact age that time we will go for this method.
		 
		 if(dao.fetchByMobile(mobile)==null && dao.fetchByEmail(email)==null
				 && dao.fetchDoctor(mobile)==null && dao.fetchDoctor(email)==null){

		Staff staff = new Staff();
		staff.setName(name);
		staff.setEmail(email);
		staff.setMobile(mobile);
		staff.setPassword(password);
		staff.setDob((dob));
		staff.setGender(gender);
		staff.setAge(age);
		
		
		
		dao.saveStaff(staff);
		
		resp.getWriter().print("<h1 style='color:green' >Staff Account Created Successufylly, wait for Admin Approval</h1>");
		resp.getWriter().print("<h1  style='color:green'>Your staff Id is : "+staff.getId()+"</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);

	}else{
		resp.getWriter().print("<h1>Mobile Number or Email already exists</h1>");
		req.getRequestDispatcher("Staff_Signup.html").include(req, resp);
	}
}
}