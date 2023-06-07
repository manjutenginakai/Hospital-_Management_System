package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Staff;
@WebServlet("/Change_Staff_Status")
public class Change_Staff_Status extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	My_Dao dao=new My_Dao();
	Staff staff=dao.fetchStaff(id);
	if(staff.isStatus())
		staff.setStatus(false);
	else
		staff.setStatus(true);
	
	dao.update(staff);
	
	resp.getWriter().print("<h1 style='color:green'>Updated successfully");
	req.setAttribute("list", dao.fetchAllStaff());
	req.getRequestDispatcher("Approve_Staff.jsp").include(req, resp);
	
}
}
