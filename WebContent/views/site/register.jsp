<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-lg-10 col-xl-9 mx-auto">
	<div
		class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
		<div class="card-img-left-register d-none d-md-flex">
			<!-- Background image for card set in CSS! -->
		</div>
		<div class="card-body p-4 p-sm-5 bg-dark text-white">
			<img class="mb-4 mx-auto d-block img-fluid"
				src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
			<h5 class="card-title text-center mb-5 fw-light fs-5">Register</h5>
			<jsp:include page="/lib/common/inform.jsp"></jsp:include>
			<form action="Register" method="post">

				<div class="form-floating mb-3">
					<input type="text" class="form-control bg-dark text-white"
						id="username" name="username" value="${user.username }"
						placeholder="myusername" required autofocus> <label
						for="floatingInputUsername">Username</label>
				</div>

				<div class="form-floating mb-3">
					<input type="email" class="form-control bg-dark text-white"
						id="email" name="email" value="${user.email }"
						placeholder="name@example.com"> <label
						for="floatingInputEmail">Email address</label>
				</div>

				<hr>

				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password1" name="password1" placeholder="Password"> <label
						for="floatingPassword">Password</label>
				</div>

				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password" name="password" placeholder="Confirm Password">
					<label for="floatingPasswordConfirm">Confirm Password</label>
				</div>

				<div class="d-grid mb-2">
					<button
						class="btn btn-lg btn-outline-primary btn-login fw-bold text-uppercase"
						type="submit">Register</button>
				</div>

				<a class="d-block text-center mt-2 small" href="#">Have an
					account? Sign In</a>

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

