package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.conn.connectDB;

@SuppressWarnings("serial")
@WebServlet("/download")
@MultipartConfig
public class DownloadFileServlet extends HttpServlet {

	public int BUFFER_SIZE = 1024 * 10000;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get the filename from the url rewriting passed attribute
		String fileName = req.getParameter("fn");

		// file folder
		String folder = "imgs";
		// construct file path
		String path = getServletContext().getRealPath("") + folder + File.separator + fileName;
		// check path
		System.out.println(path);

		// create file object
		File file = new File(path);
		OutputStream os = null;
		FileInputStream fis = null;

		try {

			if (file.exists()) {
				// set headers
				resp.setHeader("Content-Disposition", String.format("attachment;filename=\"%s\"", file.getName()));
				// set content type
				resp.setContentType("application/octet-stream");

				os = resp.getOutputStream();
				fis = new FileInputStream(file);

				// bytes according to buffer size set at a 1000 MB
				byte[] BF = new byte[BUFFER_SIZE];
				int byteRead = -1;

				while ((byteRead = fis.read(BF)) != -1) {
					os.write(BF, 0, byteRead);
				}
			} else {
				System.out.println("File does not exist. " + fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
			
			os.flush();
			if(os != null) {
				os.close();
			}
		}

	}

}