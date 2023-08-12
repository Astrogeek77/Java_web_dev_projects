<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.dao.DoctorDAO"%>
<%@page import="com.db.connectDB"%>

<div class="container p-3 pb-5">
	<p class="text-center fs-2 mb-4 text-underline">Admin Dashboard</p>
	<c:if test="${not empty errorMsg}">
		<p class="fs-3 text-center text-danger">${errorMsg}</p>
		<c:remove var="errorMsg" scope="session" />
	</c:if>
	<c:if test="${not empty succMsg}">
		<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<%
		DoctorDAO dao = new DoctorDAO(connectDB.getConn());
	%>

	<div class="row gap-5 d-flex justify-content-center">
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-md fa-3x"></i><br>
					<p class="fs-4 text-center">
						Doctors <br> <%=dao.countDoctor()%>
					</p>
					<a href="doctor.jsp" class="btn btn-sm btn-success" >Add Doctor</a>
				</div>
			</div>
		</div>



		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-circle fa-3x"></i><br>
					<p class="fs-4 text-center">
						Users <br> <%=dao.countUser()%>
					</p>
					<a href="../user_register.jsp" class="btn btn-sm btn-success disabled">Add User</a>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="far fa-calendar-check fa-3x"></i><br>
					<p class="fs-4 text-center">
						Total Appointments <br> <%=dao.countAppointment()%>
					</p>
					<a href="#" class="btn btn-sm btn-success disabled">Add Appointment</a>
				</div>
			</div>
		</div>

		<div class="col-md-4 mt-2">
			<div style="cursor: pointer;" class="card paint-card cursor-pointer">
				<div class="card-body text-center text-success">
					<i class="fas fa-notes-medical fa-3x"></i><br>
					<p class="fs-4 text-center">
						Specialisations <br><%=dao.countSpecialisation()%>
					</p>
					
					<button class="btn btn-sm btn-success"  data-bs-toggle="modal"
				data-bs-target="#exampleModal">Add Specialisation</button>
				</div>
			</div>

		</div>

	</div>
</div>

</div>
</div>