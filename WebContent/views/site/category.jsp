<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-9">
	<div class="row p-2">
		<div class="col-12 mt-1 pt-1 text-white border border-1 rounded">
			<jsp:include page="/lib/common/inform.jsp"></jsp:include>
			<div class=" name-heading_movie rounded-2">

				<h1 class="heading_movie">${video.title }</h1>
			</div>
			<div class="col-12 head ah-frame-bg position-relative bg-dark">
				<div class="col-3 pt-2 pb-2">
					<img src="${video.poster }" class="img-fluid" width="85%" />
				</div>
				<div class="col-9 position-absolute top-0 end-0">
					<table class="table table-dark table-striped table-condensed">
						<tbody>
							<tr>
								<th scope="row">Other name:</th>
								<td class="text-center">${video.otherName }</td>
							</tr>
							<tr>
								<th scope="row">Genre:</th>
								<td class="text-center"><a href="HomePage"
									class="badge bg-secondary rounded-pill">${video.videoType.getName() }</a>

								</td>

							</tr>
							<tr>
								<th scope="row">Status:</th>
								<td class="text-center">${video.action == 0 ? 'Finished' : 'Inprogress'}</td>
							</tr>
							<tr>
								<th scope="row">Scored:</th>
								<td class="text-center">${ratingPoint } || ${totalUserRated } Rated</td>
							</tr>
							<tr>
								<th scope="row">Released & Country:</th>
								<td class="text-center"><fmt:formatDate
										value="${video.createDate}" pattern="yyyy" /> &
									${video.videoCountry.getName() }</td>
							</tr>
						</tbody>

					</table>
				</div>
			</div>
			<div class="col-12 content-movie mt-2 rounded-2 position-relative">
				<div class="content-movie-play-favorite" role="group"
					aria-label="Basic mixed styles example">
					<form action="Category" method="post">
						<button type="button" class="btn btn-outline-danger">
							<i class="fa-solid fa-circle-play"></i>
						</button>
						<button formaction="categoryFavorite"
							class="btn btn-outline-warning">
							<i class="fa-solid fa-bookmark"></i>
						</button>
					</form>
				</div>
				<div class="content-movie-rate" role="group"
					aria-label="Basic mixed styles example">
					<button class="btn btn-outline-info"
						onclick="document.getElementById('send-form-email').style.display = 'block'">
						<i class="fa-solid fa-share-from-square"></i>
					</button>

					<button type="button" class="btn-rating btn btn-outline-success"
						onclick="document.getElementById('rating-form').style.display = 'block'">
						<i class="fa-solid fa-star"></i>
					</button>
				</div>
			</div>

			<div class="col-12 content-movie mt-2 rounded-2 position-relative">
				<div class="col-12 rounded-2 content-movie-summary mt-1"
					role="group" aria-label="Basic mixed styles example">
					<div class="body-content-title">
						<span class="title">Plot Summary:</span>
						<hr class="mt-2" />
					</div>

					<div class="body-content-body">
						<p>${video.desCription }</p>
					</div>
				</div>
			</div>

			<div class="col-12 comment mt-4 mb-2 rounded-2">
				<div class="fw-700 fs-16 color-yellow-2 flex flex-hozi-center">
					<span class="title">Comments:</span>
				</div>
				<div class="comment-input">
					<jsp:include page="items/item-sendComment.jsp"></jsp:include>
				</div>
				<div class="commented-user mt-2">
					<jsp:include page="items/item-comment.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-3">
	<div class="row p-2">
		<div class="col-12 mt-1 pt-1 text-white border border-1 rounded">
			<div class="content-right-title">
				<h2>RECENT RELEASE</h2>
			</div>
			<hr />
			<div class="item-recent-release">....</div>
		</div>
	</div>
</div>

<div id="rating-form"
	class="col-6 user-rating mx-auto position-absolute top-50 start-50 translate-middle"
	style="display: none; z-index: 2; opacity: 0.9;">
	<div class="col-lg-10 col-xl-9 mx-auto">
		<div
			class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
			<div
				class="card-body p-2 bg-dark text-white position-relative">
				<div class="eixt text-right position-absolute top-0 end-0">
					<button class="btn text-secondary"
						onclick="document.getElementById('rating-form').style.display = 'none'">
						<i class="fa-regular fa-2x fa-circle-xmark"></i>
					</button>
				</div>
				<img class="mb-2 mt-2 mx-auto d-block img-fluid"
					src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
				<h5 class="card-title text-center mb-3 fw-light fs-5">Film
					Rating</h5>
				<div class="ml-4">
					<jsp:include page="items/item-rating.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="send-form-email"
	class="col-6 send-form-email mx-auto position-absolute top-50 start-50 translate-middle"
	style="display: none; z-index: 2; opacity: 0.9;">
	<div class="col-lg-10 col-xl-9 mx-auto">
		<div
			class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
			<div
				class="card-body p-4 p-sm-5 bg-dark text-white position-relative">
				<div class="eixt text-right position-absolute top-0 end-0">
					<button class="btn text-secondary"
						onclick="document.getElementById('send-form-email').style.display = 'none'">
						<i class="fa-regular fa-2x fa-circle-xmark"></i>
					</button>
				</div>
				<img class="mb-4 mx-auto d-block img-fluid"
					src="<c:url value='/lib/images/Icon-logo.png'/>" alt="logo">
				<h5 class="card-title text-center mb-5 fw-light fs-5">Send This
					Video To Your Friends!</h5>
				<jsp:include page="/lib/common/inform.jsp"></jsp:include>
				<form action="Category" method="post">
					<input type="hidden" name="videoID" value="${videoID }" />
					<div class="form-floating mb-3">
						<input type="email" class="form-control bg-dark text-white"
							id="email" name="email" placeholder="name@example.com"> <label
							for="floatingInputEmail">Email address</label>
					</div>

					<div class="d-grid mb-2">
						<button
							class="btn btn-lg btn-outline-danger btn-login fw-bold text-uppercase"
							formaction="categoryShare">Send</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


