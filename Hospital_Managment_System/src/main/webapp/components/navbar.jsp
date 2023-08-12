<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav
	class="navbar navbar-expand-lg bg-success bg-gradient px-2 nav-underline link-offset-1 d-flex justify-content-evenely">
	<div class="container-fluid">
		<a class="navbar-brand fs-3 text-light" href="index.jsp"><i
			class="fa-solid fa-house-chimney"></i></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse " id="navbarText">
			<c:if test="${empty userObj }">
				<ul
					class="navbar-nav me-auto mb-2 mb-lg-0 fs-5 text-light d-flex justify-content-evenly">
					<li class="nav-item"><a class="nav-link text-light"
						href="doctor_login.jsp">Doctor Login</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						href="admin_login.jsp">Admin Login</a></li>
					<li class="nav-item"><a class="nav-link text-light"
						href="user_login.jsp">User Login</a></li>
					<li class="nav-item me-auto"><a class="nav-link text-light"
						href="user_appointment.jsp">Make Appointment</a></li>
				</ul>
			</c:if>

			<c:if test="${not empty userObj }">
				<ul
					class="navbar-nav me-auto mb-2 mb-lg-0 fs-5 text-light d-flex justify-content-evenly">
					<li class="nav-item"><a class="nav-link text-light mx-2"
						aria-current="page" href="user_appointment.jsp">Make
							Appointment</a></li>

					<li class="nav-item"><a
						class="nav-link text-light mx-2 me-auto" aria-current="page"
						href="view_appointment.jsp">View Appointments</a></li>
				</ul>
				<form class="d-flex">
						<div class="dropdown mx-5">
							<button class="btn btn-danger dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">
								<i class="fa-solid fa-circle-user"></i> ${userObj.fullname }
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="change_password.jsp">Change
										Password</a></li>
								<li><a class="dropdown-item" href="userLogout">Logout</a></li>

							</ul>
						</div>
					</form>
			</c:if>
			<span class="navbar-text fs-5 fs-lg-4 text-light"> <i
				class="fa-solid fa-stethoscope"></i> Hospital Management System CMS
			</span>
		</div>
	</div>
</nav>