package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Doctor;
@WebServlet("/Change_Doctor_Status")
public class Change_Doctor_Status extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	My_Dao dao=new My_Dao();
	Doctor doctor=dao.fetchDoctor(id);
	if(doctor.isStatus())
		doctor.setStatus(false);
	else
		doctor.setStatus(true);
	
	dao.update(doctor);
	
	resp.getWriter().print("<h1 style='color:green'>Updated successfully");
	req.setAttribute("list", dao.fetchAllDoctor());
	req.getRequestDispatcher("Approval_Doctor.jsp").include(req, resp);
	
}
}
