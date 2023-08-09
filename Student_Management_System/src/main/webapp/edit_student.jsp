<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.dao.StudentDAO" %>  
<%@page import="com.conn.connectDB" %>  
<%@page import="java.util.List" %>   
<%@page import="com.entity.Student" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SMS | Edit Student</title>
<link
      rel="icon"
      type="image/png"
      sizes="32x32"
      href="https://euimg.eworldtrade.com/uploads/user_products/6/5/product-623926-t-1539837707-o.png"
    />
<%@ include file="bootstrap.jsp" %>
</head>
<body class="bg-secondary-subtle">
	<%@ include file="navbar.jsp" %>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h2 class="fs-3 text-center">Edit Student Details Form</h2>
						
						<%
							int id = Integer.parseInt(request.getParameter("id"));
							StudentDAO studao = new StudentDAO(connectDB.getConn());
							Student student = studao.showDataId(id);
						%>
						
						
						<form action="updateStudent" method="post">
						  <input type="hidden" name="id" value="<%= student.getId() %>">
						  <div class="mb-3">
						    <label for="fullname" class="form-label" >Full Name</label>
						    <input type="text" value="<%= student.getFullname() %>" class="form-control" name="name" id="fullname">
						  </div>
						  <div class="mb-3">
						    <label for="dateofbirth" class="form-label" >Date of Birth</label>
						    <input type="date" value="<%= student.getDob() %>" class="form-control" name="dob" id="dateofbirth">
						  </div>
						  <div class="mb-3">
						    <label for="address" class="form-label" >Address</label>
						    <input type="text" value="<%= student.getAddress() %>" class="form-control" name="address" id="address">
						  </div>
						  <div class="mb-3">
						    <label for="qualification" class="form-label">Qualification</label>
						    <input type="text" value="<%= student.getQualification() %>" class="form-control" name="qualification" id="qualification">
						  </div>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Email address</label>
						    <input type="email" value="<%= student.getEmail() %>" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
						  </div>
						  <div class="mb-3 form-check">
						    <input type="checkbox" class="form-check-input" id="exampleCheck1">
						    <label class="form-check-label" for="exampleCheck1">Accept Terms and Conditions.</label>
						  </div>
						  <button type="submit" class="btn btn-primary col-md-12">Update Data</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>