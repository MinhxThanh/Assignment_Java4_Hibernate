<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="referrer" content="strict-origin" />
<title>Index</title>
<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- Dinh dang -->
<link
	href="<c:url value='/lib/fontawesome-free-6.1.1-web/css/all.css'/>"
	rel="stylesheet">
<link href="<c:url value='/lib/css/index.css'/>" rel="stylesheet">
<body>
	<header class="p-3 bg-dark text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<img src="<c:url value='/lib/images/Icon-logo.png'/>" alt=""
					class="bi me-2 img-fluid"> <!-- <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg> -->
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="VideoManagement"
						class="nav-link px-2 text-secondary"> <i
							class="fa-solid fa-list-check"></i>Video Management
					</a></li>
					<li><a href="UserManagement" class="nav-link px-2 text-white">
							<i class="fa-solid fa-user-group"></i>User Management
					</a></li>
					<li><a href="ReportManagement"
						class="nav-link px-2 text-white"><i
							class="fa-solid fa-file-chart-pie"></i> Report</a></li>
				</ul>

				<div class="text-end">
					<div class="dropdown">
						<a href="#"
							class="d-block link-dark text-decoration-none dropdown-toggle"
							id="dropdownUser2" data-bs-toggle="dropdown"
							aria-expanded="false"> <c:if
								test="${not empty sessionScope.user }">
								<img src="${user.image }" alt="mdo" width="32" height="32"
									class="rounded-circle">
							</c:if> <c:if test="${empty sessionScope.user }">
								<i class="fa-regular fa-xl fa-user text-white"></i>
							</c:if>
						</a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="dropdownMenuButton2">
							<c:if test="${not empty sessionScope.user }">
								<li><a class="dropdown-item" href="ForgotPassword"><i
										class="fa-solid fa-key"> </i> Forgot password</a></li>
								<li><a class="dropdown-item" href="ChangePassword"><i
										class="fa-solid fa-rotate-left"></i> Change password</a></li>
								<li><a class="dropdown-item" href="Editprofile"><i
										class="fa-regular fa-address-card"></i> Account</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="LogOut"><i
										class="fa-solid fa-arrow-right-from-bracket"></i> Log out</a></li>
							</c:if>
							<c:if test="${empty sessionScope.user }">
								<li><a class="dropdown-item" href="LoginPage"><i
										class="fa-solid fa-arrow-right-to-bracket"></i> Login</a></li>
							</c:if>
						</ul>

					</div>

				</div>
			</div>
		</div>
	</header>



	<%-- 	<nav class="navbar navbar-expand-lg bg-dark">
				<div class="container-fluid">
					<a class="navbar-brand" href="#"><img
						src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo"
						class="img-fluid mr-4" /></a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="col-8 collapse navbar-collapse"
						id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a aria-current="page"
								href="<c:url value='/search?action=view'/>"><i
									class="fa-solid fa-bars"></i></a>
							<li class="nav-item"><a
								href="<c:url value='/search?action=view'/>"><i
									class="fa-solid fa-clock-rotate-left"></i></a></li>
							<li class="nav-item"><a
								href="<c:url value='/search?action=view'/>"><i
									class="fa-solid fa-bookmark"></i></a></li>
							<li class="nav-item dropdown"><a
								class="nav-link pl-0 pt-2 dropdown-toggle dropdown-icon-user"
								href="#" id="navbarDropdown" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <i
									class="fa-solid fa-user" aria-hidden="true"></i>
							</a>
								<ul class="dropdown-menu bg-dark"
									aria-labelledby="navbarDropdown">
									<li><a class="dropdown-item" href="<c:url value='/'/>"><i
											class="fa-solid fa-key"> </i> Forgot password</a></li>
									<li><a class="dropdown-item" href="<c:url value='/'/>"><i
											class="fa-solid fa-rotate-left"></i> Change password</a></li>
									<li><a class="dropdown-item" href="<c:url value='/'/>"><i
											class="fa-solid fa-address-card"></i> Account</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="<c:url value='/'/>"><i
											class="fa-solid fa-arrow-right-from-bracket"></i> Log out</a></li>
								</ul></li>
							<li class="nav-item">
								<a class="position-relative">
									<i
									class="fa-solid text-white fa-bell"></i> <span
										class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-secondary">+99
										<span class="visually-hidden">unread messages</span>
									</span>
								</a> <a href="<c:url value='/search?action=view'/>"><i
									class="fa-solid fa-bell"></i></a>
							</li>
						</ul>
						<form class="col-6 d-flex" role="search">
							<input
								class="form-control ml-5 bg-dark border-end-0 rounded-start rounded-0"
								type="search" placeholder="Search" aria-label="Search">
							<button class="col-1 btn btn-outline-light pl-2" type="submit">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</form>
					</div>
				</div>
			</nav>
 --%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>