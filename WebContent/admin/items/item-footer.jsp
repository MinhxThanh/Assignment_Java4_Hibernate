<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>
<body>
	<footer
		class="row d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
		<div class="col-md-4 d-flex align-items-center">
			<a href="/"> <img
				src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo"
				class="img-fluid" width="70%" />
			</a>
		</div>

		<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
			<li class="ms-3"><a class="text-white"
				href="https://www.facebook.com/Mr.MinhxThanh"><i
					class="fa-brands fa-2x fa-facebook white"></i></a></li>
			<li class="ms-3"><a class="text-white"
				href="https://www.facebook.com/Mr.MinhxThanh"><i
					class="fa-brands fa-2x fa-instagram"></i></a></li>
			<li class="ms-3"><a class="text-white"
				href="https://t.me/MinhxThanh"><i
					class="fa-brands fa-2x fa-telegram"></i></a></li>
			<li class="ms-3"><a class="text-white"
				href="https://twitter.com/Thnh92475449"><i
					class="fa-brands fa-2x fa-twitter"></i></a></li>
		</ul>
	</footer>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>
