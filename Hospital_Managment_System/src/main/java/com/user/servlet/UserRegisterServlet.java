package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.connectDB;
import com.dao.UserDAO;
import com.entity.User;

@SuppressWarnings("serial")
@WebServlet("/registerUser")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get form parameters values
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// Create Student class Object
		User student = new User(name, email, password);
		
//		// print values
//		System.out.println(student);
		
		UserDAO studao = new UserDAO(connectDB.getConn());
		boolean resp1 = studao.insertData(student);
		
		// create http session instance
		HttpSession session = req.getSession();
		
		if(resp1) {
			session.setAttribute("respInsertSuccess", "User Registered Successfully.");
		} else {
			session.setAttribute("respInsertError", "Something went wrong while inserting data.");
		}
		resp.sendRedirect("user_register.jsp");
	}
	
	
}