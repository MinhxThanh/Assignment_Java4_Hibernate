<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<title>${page.title}</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/A-S-M/" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />


<link
	href="<c:url value='/lib/fontawesome-free-6.1.1-web/css/all.css'/>"
	rel="stylesheet">
<link href="<c:url value='/lib/css/index.css'/>" rel="stylesheet">
</head>
<body class="bg-black">

	<main class="container col-11">
		<header class="row">
			<%@include file="items/item-header-admin.jsp"%>
		</header>
		<section class="row justify-content-center">
			<%-- <jsp:include page="reports/reports.jsp"></jsp:include> --%>
			<jsp:include page="${page.contentUrl}"></jsp:include>
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

		$('#myTab a').on('click', function(event) {
			event.preventDefault()
			$(this).tab('show')
		})
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>


</body>
</html>
