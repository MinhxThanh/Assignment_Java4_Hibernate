<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Swiper</title>
</head>
<body>
	<div class="containers">
		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value='/lib/images/i-1.jpg'/>" style="max-height: 300px;"
						class="d-block w-100 img-fluid" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Sắp khởi chiếu!</h5>
						<p>Xem sớm nhất tại ZayFlim</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/lib/images/i-2.jpg'/>" style="max-height: 300px;"
						class="d-block w-100 img-fluid" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Bạn đã xem TOM CRUISE?</h5>

					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/lib/images/i-3.jpg'/>" style="max-height: 300px;"
						class="d-block w-100 img-fluid" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Cùng xem phần mới nhất nào!!</h5>

					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/lib/images/i-4.jpg'/>" style="max-height: 300px;"
						class="d-block w-100 img-fluid" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Xem phần mới nhất của bác sĩ lạ tại đây!!</h5>

					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/lib/images/i-5.jpg'/>" style="max-height: 300px;"
						class="d-block w-100 img-fluid" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Bạn đã xem phim này chưa?</h5>

					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleFade"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleFade"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.6/dist/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
</body>
</html>