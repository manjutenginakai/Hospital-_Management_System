package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Patient;

@WebServlet("/Staff_Fetch_Patient_History")
public class Fetch_Patient_History extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("staff") == null) {
			resp.getWriter().print("<h1 style='color:red'>Session Expired</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			My_Dao dao = new My_Dao();
			List<Patient> list = dao.fetchAllPatient();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red'>No Patient Data Found</h1>");
				req.getRequestDispatcher("StaffHome.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("View_Patient_History2.jsp").forward(req, resp);
			}
		}
	}
}
