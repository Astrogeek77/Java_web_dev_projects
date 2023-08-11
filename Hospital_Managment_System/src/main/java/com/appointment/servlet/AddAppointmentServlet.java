package com.appointment.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.db.connectDB;
import com.entity.Appointment;

@SuppressWarnings("serial")
@WebServlet("/appAppointment")
public class AddAppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointmentDate = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String diseases = req.getParameter("diseases");
		int doctor_id = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");

		Appointment ap = new Appointment(userId, fullname, gender, age, appointmentDate, email, phno, diseases,
				doctor_id, address, "Pending");

		AppointmentDAO dao = new AppointmentDAO(connectDB.getConn());
		HttpSession session = req.getSession();

		if (dao.addAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment Created Sucessfully");
			resp.sendRedirect("user_appointment.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("user_appointment.jsp");
		}

	}

}