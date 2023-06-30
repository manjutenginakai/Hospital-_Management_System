package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Doctor;
@WebServlet("/Fetch_all_Doctor")
public class Fetch_all_Doctor extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if(req.getSession().getAttribute("admin")!=null)
	{
	My_Dao dao=new My_Dao();
	List<Doctor> list=dao.fetchAllDoctor();
	if(list.isEmpty()){
		resp.getWriter().print("<h1 style='color:red'>No staff is signed up yet </h1>");
		req.getRequestDispatcher("Admin_Home.html").include(req, resp);
	}else{
		req.setAttribute("list", list);
		req.getRequestDispatcher("Approval_Doctor.jsp").include(req, resp);
	}
}
	else{
		resp.getWriter().print("<h1 style='color:red'>Session Expired,Login again</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
}
