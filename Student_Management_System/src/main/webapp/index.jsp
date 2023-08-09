<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %> 
    
<%@page import="com.dao.StudentDAO" %>  
<%@page import="com.conn.connectDB" %>  
<%@page import="java.util.List" %>   
<%@page import="com.entity.Student" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SMS | Home Page</title>
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
	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<h1 class="my-4 text-center">All Student Details</h1>
				
				<c:if test="${not empty respInsertSuccess}">
					<p class="text-center text-success">${respInsertSuccess }</p>
					<c:remove var="respInsertSuccess"/>
				</c:if>
				<c:if test="${not empty respInsertError}">
					<p class="text-center text-success">${respInsertError }</p>
					<c:remove var="respInsertError"/>
				</c:if>
				
				<c:if test="${not empty respDeleteSuccess}">
					<p class="text-center text-success">${respDeleteSuccess }</p>
					<c:remove var="respDeleteSuccess"/>
				</c:if>
				<c:if test="${not empty respDeleteError}">
					<p class="text-center text-success">${respDeleteError }</p>
					<c:remove var="respDeleteError"/>
				</c:if>
				
				<c:if test="${not empty respUpdateSuccess}">
					<p class="text-center text-success">${respUpdateSuccess }</p>
					<c:remove var="respUpdateSuccess"/>
				</c:if>
				<c:if test="${not empty respUpdateError}">
					<p class="text-center text-success">${respUpdateError }</p>
					<c:remove var="respUpdateError"/>
				</c:if>
				
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">FullName</th>
				      <th scope="col">Date of Birth</th>
				      <th scope="col">Address</th>
				      <th scope="col">Qualification</th>
				      <th scope="col">Email</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<% 
				  		StudentDAO studao = new StudentDAO(connectDB.getConn());
				  		List<Student> studentData = studao.showData();
				  		
				  		for(Student student: studentData){
				  	%>			  
					    <tr>
					      <th scope="row"><%= student.getFullname() %></th>
					      <td><%= student.getDob() %></td>
					      <td><%= student.getAddress() %></td>
					      <td><%= student.getQualification() %></td>
					      <td><%= student.getEmail() %></td>
					      <td>
					      	<a href="edit_student.jsp?id=<%= student.getId() %>" class="btn btn-sm btn-primary">Edit</a>
					      	<a href="deleteStudent?id=<%= student.getId() %>" class="btn btn-sm btn-danger">Delete</a>
					      </td>
					    </tr>
					    
				    <% } %>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>