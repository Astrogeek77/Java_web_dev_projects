<nav
	class="navbar navbar-expand-lg bg-success bg-gradient px-2 nav-underline link-offset-1">
	<div class="container-fluid">
		<a class="navbar-brand fs-3 text-light" href="../index.jsp"><i
			class="fa-solid fa-house-chimney"></i></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 fs-4 text-light">
				<li class="nav-item mx-2"><a class="nav-link text-light"
					href="doctor.jsp">Add Doctor</a></li>
				<li class="nav-item mx-2"><a class="nav-link text-light"
					href="view_doctor.jsp">View Doctors</a></li>
				<li class="nav-item mx-2"><a class="nav-link text-light"
					href="view_patient.jsp">View Patients</a></li>
				<li class="nav-item mx-2"><a class="nav-link text-light"
					href="index.jsp">Dashboard</a></li>
			</ul>
			<div class="dropdown">
				<button class="btn btn-danger border-none dropdown-toggle me-4 text-light fs-5" type="button"
					data-bs-toggle="dropdown" aria-expanded="false">Admin</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="../adminLogout">Logout</a></li>
					<li><a class="dropdown-item" href="../index.jsp">Home Page</a></li>
				</ul>
			</div>
			<span class="navbar-text fs-5 fs-lg-4 text-light"> <i
				class="fa-solid fa-stethoscope"></i> Hospital CMS Admin
			</span>
		</div>
	</div>
</nav>