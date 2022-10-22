<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <div class="col-2 mt-2"> -->
<c:forEach var="item" items="${videos }">
	<div class="col-6 col-md-3 mt-2 mb-2">
		<div class="cart text-center border border-dark ">
			<div class="cart-body">
				<a type="submit" href="Category?id=${item.videoID }"
					style="width: 100%;"><img
					src="${empty item.poster ? '/lib/images/avatar.jpg' : item.poster }"
					width="100%" alt="avatar" class="img-fluid cart-body-image" /> <span
					class="middle"> <i class="fa-solid fa-circle-play"></i>
				</span> </a>
			</div>
			<div class="cart-footer mt-1">
				<div class="row boder-top">
					<a class="cart-footer-name" href="Category?id=${item.videoID }">
						<span
						style="font-size: 1.3vw; display: inline-block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 22ch; font-weight: 700;">
							${item.title } </span>
					</a>
				</div>
				<div class="row cart-year">
					<p class="text-white" style="font-size: 0.88vw;">
						Released:
						<fmt:formatDate value="${item.createDate}" pattern="yyyy" />
					</p>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<div class="page-nav mt-4">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:if test="${currentPage == 0}">
				<li class="page-item"><a class="page-link bg-dark text-white"
					href="HomePage?page=1">Prev</a></li>
				<li class="page-item"><a class="page-link bg-dark text-white"
					href="HomePage?page=1">1</a></li>
				<li class="page-item"><a class="page-link bg-dark text-white"
					href="HomePage?page=2">2</a></li>
			</c:if>
			<c:if test="${currentPage >= 1}">
				<li class="page-item"><a class="page-link bg-dark text-white"
					href="HomePage?page=${currentPage }">Prev</a></li>
			</c:if>
			<c:if test="${currentPage >= 1}">
				<c:forEach var='p' begin="${currentPage}" end="${currentPage + 2}"
					step="1">
					<c:if test="${p <= totalPage}">
						<li class="page-item"><a class="page-link bg-dark text-white"
							href="HomePage?page=${p}">${p}</a></li>
					</c:if>
				</c:forEach>
			</c:if>
			<li class="page-item bg-dark text-white"><a class="page-link"
				href="HomePage?page=${totalPage}">Last</a></li>
		</ul>
	</nav>
</div>

<%-- <div class="col-3 mt-2 mb-2">
		<div class="cart text-center border border-dark ">
			<div class="cart-body">
				<a type="submit" href="Category"><img
					src="<c:url value='/lib/images/avatar.jpg'/>" width="100%"
					alt="avatar" class="img-fluid cart-body-image" /> <span
					class="middle"> <i class="fa-solid fa-circle-play"></i>
				</span> </a>
			</div>
			<div class="cart-footer mt-2">
				<div class="row boder-top">
					<a type="submit" class="cart-footer-name" href="Category"><b>VENOM:
							LET THERE BE CARNAGE</b></a>
				</div>
				<div class="row cart-year">
					<p class="text-white">Released: 2021</p>
				</div>
			</div>
		</div>
	</div> --%>