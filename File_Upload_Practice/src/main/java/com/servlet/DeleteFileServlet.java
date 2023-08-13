package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.connectDB;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get file id
		int id = Integer.parseInt(req.getParameter("id"));
		boolean result = false;
		HttpSession session = req.getSession();
		try {
			Connection conn = connectDB.getConn();
			String query = "delete from files where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			// response upon executing query, output as 1 signifies successful operation
			int res = ps.executeUpdate();
			if (res == 1) {
				result = true;
			}
			
			if(result) {
				System.out.println("File Deleted Successfully.");
				session.setAttribute("msg", "File Deleted Successfully.");
			} else {
				System.out.println("Something went Wrong");
				session.setAttribute("ErrMsg", "Something went Wrong");
			}
			resp.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
