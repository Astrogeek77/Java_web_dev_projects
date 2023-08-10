<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

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

	<div class="row gap-5 d-flex justify-content-center">
		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-md fa-3x"></i><br>
					<p class="fs-4 text-center">
						Doctor <br> 3
					</p>
					<a href="#" class="btn btn-sm btn-success disabled"  data-bs-toggle="modal"
				data-bs-target="#exampleModal">Add Doctor</a>
				</div>
			</div>
		</div>



		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="fas fa-user-circle fa-3x"></i><br>
					<p class="fs-4 text-center">
						User <br> 4
					</p>
					<a href="#" class="btn btn-sm btn-success disabled"  data-bs-toggle="modal"
				data-bs-target="#exampleModal">Add User</a>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<div class="card paint-card">
				<div class="card-body text-center text-success">
					<i class="far fa-calendar-check fa-3x"></i><br>
					<p class="fs-4 text-center">
						Total Appointment <br>5
					</p>
					<a href="#" class="btn btn-sm btn-success disabled"  data-bs-toggle="modal"
				data-bs-target="#exampleModal">Add Appointments</a>
				</div>
			</div>
		</div>

		<div class="col-md-4 mt-2">
			<div style="cursor: pointer;" class="card paint-card cursor-pointer">
				<div class="card-body text-center text-success">
					<i class="fas fa-notes-medical fa-3x"></i><br>
					<p class="fs-4 text-center">
						Specialist <br>6
					</p>
					
					<button class="btn btn-sm btn-success"  data-bs-toggle="modal"
				data-bs-target="#exampleModal">Add Specialist</button>
				</div>
			</div>

		</div>

	</div>
</div>

</div>
</div>