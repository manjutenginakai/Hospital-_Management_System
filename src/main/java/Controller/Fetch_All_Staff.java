package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Staff;

@WebServlet("/Fetch_all_staff")
public class Fetch_All_Staff extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	if(req.getSession().getAttribute("admin")!=null)
	{
	My_Dao dao=new My_Dao();
	List<Staff> list=dao.fetchAllStaff();
	if(list.isEmpty()){
		resp.getWriter().print("<h1 style='color:red'>No staff is signed up yet </h1>");
		req.getRequestDispatcher("Admin_Home.html").include(req, resp);
	}else{
		req.setAttribute("list", list);
		req.getRequestDispatcher("Approve_Staff.jsp").include(req, resp);
	}

	}
	else{
		resp.getWriter().print("<h1 style='color:red'>Session Expired,Login again</h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
}

