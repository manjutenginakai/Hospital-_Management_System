package Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Appointment;

@WebServlet("/checkappointment")
public class Check_Appointment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		My_Dao dao = new My_Dao();

		Appointment appointment = dao.fetchAppointment(id);
		appointment.setTime(LocalDateTime.now());
		dao.updateAppointment(appointment);

		resp.getWriter().print("<h1>Successfully Updated</h1>");
		req.getRequestDispatcher("Doctor_Home.html").include(req, resp);
	}
}
