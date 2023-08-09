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

@SuppressWarnings("serial")
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get form parameters values
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDAO studao = new StudentDAO(connectDB.getConn());
		boolean resp1 = studao.deleteData(id);
		
		// create http session instance
		HttpSession session = req.getSession();
		
		if(resp1) {
			session.setAttribute("respDeleteSuccess", "Student Data Deleted Successfully.");
		} else {
			session.setAttribute("respDeleteError", "Something went wrong while deleting data.");
		}
		resp.sendRedirect("index.jsp");
	}
}