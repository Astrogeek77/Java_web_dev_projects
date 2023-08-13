<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.connectDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./components/cdns.jsp"%>
<meta charset="ISO-8859-1">
<title>Image Upload Practice</title>

</head>
<body class="bg-light">

	<div class="container">
		<div class="row">
			<div class="col-md-12 mt-3">
				<div class="card">
					<div class="card-body">
						<p class="text-center fs-3">Image Upload</p>

						<%
						String msg = (String) session.getAttribute("msg");
						if (msg != null) {
						%>
						<h4 class="text-center text-success"><%=msg%></h4>
						<%
						session.removeAttribute("msg");
						}
						%>
						<%
						String ErrMsg = (String) session.getAttribute("ErrMsg");
						if (ErrMsg != null) {
						%>
						<h4 class="text-center text-danger"><%=ErrMsg%></h4>
						<%
						session.removeAttribute("ErrMsg");
						}
						%>
						<form method="post" action="upload" enctype="multipart/form-data">
							<div class="mb-3">
								<label>Image</label> <input type="file" name="file"
									class="form-control">
							</div>

							<div class="mb-3">
								<label>Remark</label> <input type="text" name="remark"
									class="form-control">
							</div>
							<div class="text-center">
								<button class="btn btn-primary">Upload</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

		<h2 class="my-4 text-center fs-5">
			Images are being uploaded at this location: <b>C:\Coding\Java\Java
				Web Dev
				Practice\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\File_Upload_Practice\imgs</b>
		</h2>
		<table class="table mt-4">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">FileName</th>
					<th scope="col">Remark</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				Connection conn = connectDB.getConn();

				PreparedStatement ps = conn.prepareStatement("select * from files");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
				%>
				<tr>
					<%
					if (rs.getString("file_name").endsWith(".pdf")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_pdf.png"
						width="200px" height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".xlsx") || rs.getString("file_name").endsWith(".xls")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_xlxs.png"
						width="200px" height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".png")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon.png" width="200px"
						height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".svg")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_svg.png"
						width="200px" height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".mp4") || rs.getString("file_name").endsWith(".mkv")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_video.png"
						width="200px" height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".mp3")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_mp3.png"
						width="200px" height="100px"></th>
					<%
					} else if (rs.getString("file_name").endsWith(".txt")) {
					%>
					<th scope="row"><img alt="" src="imgs/icon_txt.png"
						width="200px" height="100px"></th>
					<%
					} else {
					%>
					<th scope="row"><img alt=""
						src="imgs/<%=rs.getString("file_name")%>" width="200px"
						height="100px"></th>
					<%
					}
					%>
					<td><%=rs.getString("file_name")%></td>
					<td><%=rs.getString("remark")%></td>
					<td>
						<a class="btn btn-primary" href="download?fn=<%=rs.getString("file_name")%>">Download</a>
						<a class="btn btn-danger" href="delete?id=<%=rs.getInt("id")%>">Delete</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>