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
			<form action="ChangePassword" method="post">

				<div class="form-floating mb-3">
					<input type="hidden" class="form-control bg-dark text-white"
						id="email" name="email" value="${user.email }"
						placeholder="name@example.com"> <label
						for="floatingInputEmail">Email address</label>
				</div>

				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password" name="oldPassword" placeholder="Password"> <label
						for="floatingPassword">Old Password</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password" name="newPassword" placeholder="Password"> <label
						for="floatingPassword">New Password</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" class="form-control bg-dark text-white"
						id="password" name="comfrimPassword" placeholder="Password"> <label
						for="floatingPassword">Comfrim Password</label>
				</div>

				<div class="d-grid mb-2">
					<button
						class="btn btn-lg btn-outline-primary btn-login fw-bold text-uppercase"
						type="submit">Change Password</button>
				</div>
			</form>
		</div>
	</div>
</div>

