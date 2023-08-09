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
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get form parameters values
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		
		// Create Student class Object
		Student student = new Student(name, dob, address, qualification, email);
		
//		// print values
//		System.out.println(student);
		
		StudentDAO studao = new StudentDAO(connectDB.getConn());
		boolean resp1 = studao.insertData(student);
		
		// create http session instance
		HttpSession session = req.getSession();
		
		if(resp1) {
			session.setAttribute("respInsertSuccess", "Student Data insterted Successfully.");
		} else {
			session.setAttribute("respInsertError", "Something went wrong while inserting data.");
		}
		resp.sendRedirect("index.jsp");
	}
	
	
}
