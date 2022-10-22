<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-10 col-xl-9 mx-auto">
	<div
		class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
		<div class="card-img-left-login d-none d-md-flex">
			<!-- Background image for card set in CSS! -->
		</div>
		<div class="card-body p-4 p-sm-5 bg-dark text-white">
			<img class="mb-4 mx-auto d-block img-fluid"
				src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
			<h5 class="card-title text-center mb-5 fw-light fs-5">Login</h5>
			<jsp:include page="/lib/common/inform.jsp"></jsp:include>
			<form action="LoginPage" method="post">

				<div class="form-floating mb-3">
					<input type="email" class="form-control bg-dark text-white"
						id="email" name="email" value="${user.email }"
						placeholder="name@example.com"> <label
						for="floatingInputEmail">Email address</label>
				</div>

				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password" name="password" placeholder="Password"> <label
						for="floatingPassword">Password</label>
				</div>
				<div class="form-check">
					<input name="remember" type="checkbox"
						class="form-check-input bg-secondary" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>

				<div class="d-grid mb-2">
					<button
						class="btn btn-lg btn-outline-primary btn-login fw-bold text-uppercase"
						type="submit">Login</button>
				</div>

				<a class="d-block text-center mt-2 small" href="Register">Have
					an account? Register</a>

				<hr class="my-4">

				<div class="d-grid mb-2">
					<button
						class="btn btn-outline-danger btn-lg btn-google btn-login fw-bold text-uppercase"
						type="submit">
						<i class="fab fa-google me-2"></i> Sign up with Google
					</button>
				</div>

				<div class="d-grid">
					<button
						class="btn btn-outline-primary btn-lg btn-facebook btn-login fw-bold text-uppercase"
						type="submit">
						<i class="fab fa-facebook-f me-2"></i> Sign up with Facebook
					</button>
				</div>

			</form>
		</div>
	</div>
</div>





<%-- <div class="row col-12 justify-content-center">
<div class="col-4 p-4 m-2 text-white rounded bg-dark">
	<form class="form-signin boder-warning">
		<img class="mb-4 mx-auto d-block img-fluid"
			src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
		<h1 class="h3 mb-3 font-weight-normal text-center">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" class="form-control bg-dark text-white"
			placeholder="Email address" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword"
			class="form-control bg-dark text-white" placeholder="Password"
			required>
		<div class="checkbox mb-3">
			<div class="form-check form-switch">
				<input class="form-check-input" type="checkbox" role="switch"
					id="flexSwitchCheckDefault" value="remember-me"> <label
					class="form-check-label" for="flexSwitchCheckDefault">Remember
					me</label>
			</div>
		</div>
		<div class="d-grid gap-2">

			<button class="btn btn-lg btn-outline-primary btn-block"
				type="submit">Sign in</button>
		</div>
	</form>
</div>
</div> --%>