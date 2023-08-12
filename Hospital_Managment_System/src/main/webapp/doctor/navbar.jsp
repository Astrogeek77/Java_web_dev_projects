
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success nav-underline">
	<div class="container-fluid">
		<a class="navbar-brand fs-3 text-light" href="index.jsp"><i
			class="fa-solid fa-house-chimney"></i></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-4">
				<li class="nav-item"><a class="nav-link text-light" href="index.jsp">Dashbaord</a></li>
				<li class="nav-item"><a class="nav-link text-light" href="patient.jsp">View Patients</a></li>
			</ul>

			<form class="d-flex">
				<div class="dropdown me-4">
					<button class="btn btn-danger dropdown-toggle btn-danger" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${doctObj.fullName }
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="edit_profile.jsp">Edit
								Profile</a></li>
						<li><a class="dropdown-item" href="../doctorLogout">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
		<span class="navbar-text fs-5 fs-lg-4 text-light"> <i
			class="fa-solid fa-stethoscope"></i> Hospital CMS Doctor Dashboard
		</span>
	</div>
</nav>