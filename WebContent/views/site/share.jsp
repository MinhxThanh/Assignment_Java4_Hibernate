<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link
	href="<c:url value='/lib/fontawesome-free-6.1.1-web/css/all.css'/>"
	rel="stylesheet">
</head>
<body>
	<div class="col-6 send-form-email mx-auto">
		<div class="col-lg-10 col-xl-9 mx-auto">
			<div
				class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
				<div class="card-body p-4 p-sm-5 bg-dark text-white position-relative">
					<div class="eixt text-right position-absolute top-0 end-0">
						<button class="btn text-secondary" onclick="document.getElementById('send-form-email').style.display = 'none'">
							<i class="fa-regular fa-2x fa-circle-xmark"></i>
						</button>
					</div>
					<img class="mb-4 mx-auto d-block img-fluid"
						src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
					<h5 class="card-title text-center mb-5 fw-light fs-5">Send
						This Video To Your Friends!</h5>
					<jsp:include page="/lib/common/inform.jsp"></jsp:include>
					<form action="LoginPage" method="post">

						<div class="form-floating mb-3">
							<input type="email" class="form-control bg-dark text-white"
								id="email" name="email" value="${user.email }"
								placeholder="name@example.com"> <label
								for="floatingInputEmail">Email address</label>
						</div>

						<div class="d-grid mb-2">
							<button
								class="btn btn-lg btn-outline-danger btn-login fw-bold text-uppercase"
								type="submit">Send</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>
