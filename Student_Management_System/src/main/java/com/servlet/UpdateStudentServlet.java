package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.connectDB;
import com.dao.StudentDAO;
import com.entity.Student;

@SuppressWarnings("serial")
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get form parameters values
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		
		// Create Student class Object
		Student student = new Student(id, name, dob, address, qualification, email);
		
//		// print values
//		System.out.println(student);
		
		StudentDAO studao = new StudentDAO(connectDB.getConn());
		boolean resp1 = studao.updateData(student);
		
		// create http session instance
		HttpSession session = req.getSession();
		
		if(resp1) {
			session.setAttribute("respUpdateSuccess", "Student Data Updated Successfully.");
		} else {
			session.setAttribute("respUpdateError", "Something went wrong while updating data.");
		}
		resp.sendRedirect("index.jsp");
	}
}
