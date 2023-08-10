<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMS | User Register</title>
<%@include file="components/cdns.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Register</p>

						<c:if test="${not empty respInsertSuccess }">
							<p class="text-center text-success fs-5">${respInsertSuccess}</p>
							<c:remove var="respInsertSuccess" scope="session" />
						</c:if>

						<c:if test="${not empty respInsertError }">
							<p class="text-center text-danger fs-5">${respInsertError}</p>
							<c:remove var="respInsertError" scope="session" />
						</c:if>

						<form action="registerUser" method="post">
						<div class="mb-3">
								<label class="form-label">Full Name</label> <input required
									name="fullname" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email address</label> <input required
									name="email" type="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>

						<br> Already have an account? <a href="user_login.jsp"
							class="text-decoration-none"> Login</a>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="./components/footer.jsp"%>
</body>
</html>