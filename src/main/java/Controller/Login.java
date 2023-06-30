package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Doctor;
import Dto.Staff;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("Id"));
		String password = req.getParameter("Password");

		My_Dao dao = new My_Dao();
		Doctor doctor = dao.fetchDoctor(id);
		Staff staff = dao.fetchStaff(id);

		if (staff == null && doctor == null && id != 999999) {
			resp.getWriter().print("<h1 style='color:red'>Incorrect Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (staff != null) {
				if (staff.getPassword().equals(password)) {
					if (staff.isStatus()) {
						req.getSession().setAttribute("staff", staff);
						resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
						req.getRequestDispatcher("Staff_Home.html").include(req, resp);
					} else {
						resp.getWriter().print("<h1 style='color:red'>Wait for Admin Approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
				} else {
					resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
			if (doctor != null) {
				if (doctor.getPassword().equals(password)) {
					if (doctor.isStatus()) {
						req.getSession().setAttribute("doctor", doctor);
						resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
						req.getRequestDispatcher("Doctor_Home.html").include(req, resp);
					} else {
						resp.getWriter().print("<h1 style='color:red'>Wait for Admin Approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
				} else {
					resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
			if (id == 999999) {
				if ("999999".equals(password)) {
					req.getSession().setAttribute("admin", "admin");
					resp.getWriter().print("<h1 style='color:green'>Login success</h1>");
					req.getRequestDispatcher("Admin_Home.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
		}
	}
}
