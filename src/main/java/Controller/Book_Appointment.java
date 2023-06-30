package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.My_Dao;
import Dto.Appointment;
import Dto.Doctor;
import Dto.Patient;

@WebServlet("/Book_Appointment")
public class Book_Appointment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		int did = Integer.parseInt(req.getParameter("doctor"));
		String problem = req.getParameter("problem");
		My_Dao dao = new My_Dao();
		Doctor doctor = dao.fetchDoctor(did);
		Patient patient = dao.fetchPatient(pid);

		Appointment appointment = new Appointment();
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setProblem(problem);
		
		// For Patient
		List<Appointment> list = patient.getAppointment();
		if (list == null) {
			list = new ArrayList<Appointment>();
		}
		list.add(appointment);
		patient.setAppointment(list);

		// For Doctor
		List<Appointment> list1 = doctor.getAppointment();
		if (list1 == null) {
			list1 = new ArrayList<Appointment>();
		}
		list.add(appointment);
		doctor.setAppointment(list1);
		
		dao.saveAppointment(appointment);
		dao.update(doctor);
		dao.update(patient);
		
		resp.getWriter().print("<h1>Appointment of " + patient.getName() + " is booked with " + doctor.getName()
				+ " for " + problem + "</h1>");
		req.getRequestDispatcher("Staff_Home.html").include(req, resp);
	}

}
