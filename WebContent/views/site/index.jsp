<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${page.title }</title>
<base href="/A-S-M/" />
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!-- font awesome -->
<link
	href="<c:url value='/lib/fontawesome-free-6.1.1-web/css/all.css'/>"
	rel="stylesheet">
<!-- css -->
<link href="<c:url value='/lib/css/index.css'/>" rel="stylesheet">
<link href="<c:url value='/lib/css/item-content.css'/>" rel="stylesheet">
<link href="<c:url value='/lib/css/category.css'/>" rel="stylesheet">

</head>
<body class="bg-black">
	<main class="container col-11">
		<header class="row">
			<%@include file="items/item-header.jsp"%>
		</header>
		<nav class="row border border-2 rounded">
			<div class="col-12">
				<%@include file="swiper.jsp"%>
			</div>
		</nav>
		<section class="row border border-2 rounded mt-3">
			<div class="col-12">
				<div class="row position-relative ">

					<jsp:include page="${page.contentUrl }"></jsp:include>

				</div>
			</div>
		</section>

		<!-- footer -->

		<%@include file="items/item-footer.jsp"%>

	</main>

	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>
	<script type="text/javascript">
		function preview() {
			frame.src = URL.createObjectURL(event.target.files[0]);
		}
		function clearImage() {
			document.getElementById('formFile').value = null;
			frame.src = "";
		}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

</body>
</html>
