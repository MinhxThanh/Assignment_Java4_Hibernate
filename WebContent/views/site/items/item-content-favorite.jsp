<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="item" items="${favorite }">
	<div class="col-3 mt-2 mb-2">
		<div class="cart text-center border border-dark ">
			<div class="cart-body position-relative">
				<div class="exit text-right position-absolute top-0 end-0">
					<form action="FavoriteVideo" method="post" class="form-delete-btn">
						<input type="hidden" name="videoID" value="${item.videoID }" />
						<button type="submit"
							class="btn text-secondary btn-delete-favoriteVideo"
							style="z-index: 3;">
							<i class="fa-regular fa-2x fa-circle-xmark"></i>
						</button>
					</form>
				</div>
				<a type="submit" href="Category?id=${item.videoID }"><img
					src="${empty item.poster ? '/lib/images/avatar.jpg' : item.poster }"
					width="100%" alt="avatar" class="img-fluid cart-body-image" /> <span
					class="middle"> <i class="fa-solid fa-circle-play"></i>
				</span> </a>
			</div>
			<div class="cart-footer mt-2">
				<div class="row boder-top">
					<a type="submit" class="cart-footer-name"
						href="Category?id=${item.videoID }"><b>${item.title }</b></a>
				</div>
				<div class="row cart-year">
					<p class="text-white">
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
			<li class="page-item"><a class="page-link bg-dark text-white"
				href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
			</a></li>
			<li class="page-item"><a class="page-link bg-dark text-white"
				href="#">1</a></li>
			<li class="page-item"><a class="page-link bg-dark text-white"
				href="#">2</a></li>
			<li class="page-item"><a class="page-link bg-dark text-white"
				href="#">3</a></li>
			<li class="page-item"><a class="page-link bg-dark text-white"
				href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
</div>
