<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="col-10">
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<a class="nav-link active" id="nav-videoEditing-tab" data-toggle="tab"
			href="#nav-videoEditing" role="tab" aria-controls="nav-home"
			aria-selected="true">Favorites</a> <a class="nav-link"
			id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
			aria-controls="nav-profile" aria-selected="false">Favorite User</a> <a
			class="nav-link" id="nav-shareFriends-tab" data-toggle="tab"
			href="#nav-shareFriends" role="tab" aria-controls="nav-shareFriends"
			aria-selected="false">Share Friends</a>
	</div>
</nav>
<div class="col-10 tab-content" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-videoEditing"
		role="tabpanel" aria-labelledby="nav-videoEditing-tab">
		<table class="table table-stripe table-dark text-center">
			<thead>
				<tr>
					<td>Video Title</td>
					<td>Favorites Count</td>
					<td>Lasted Date</td>
					<td>Oldest Date</td>
				</tr>
			</thead>
			<c:forEach var="item" items="${favoriteList }">
				<tr>
					<td>${item.videoTitle }</td>
					<td>${item.favoriteCount }</td>
					<td><fmt:formatDate value="${item.newestDate }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${item.oldestDate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="tab-pane fade" id="nav-profile" role="tabpanel"
		aria-labelledby="nav-profile-tab">
		<form action="">
			<div class="reo mt-3">
				<div class="col">
					<div class="form-inline">
						<div class="form-group">
							<label class="form-label text-white" for="select">Video
								Title:</label> <select class="form-control ml-1 mr-1" name="videoUserID"
								id="videoUserID">
								<c:forEach var="item" items="${vlList}">
									<option value="${item.videoID}"
									${item.videoID == videoUserID ? 'selected' : '' }>${item.title }</option>
								</c:forEach>
							</select>

							<button class="btn btn-outline-info">Report</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col mt-3">
					<table class="table table-stripe table-dark text-center">
						<tr>
							<td>User ID</td>
							<td>Username</td>
							<td>Email</td>
							<td>Favorite Date</td>
						</tr>
						<c:forEach var="item" items="${FavoriteUser}">
						<tr>
							<td>${item.userID }</td>
							<td>${item.username }</td>
							<td>${item.email }</td>
							<td><fmt:formatDate value="${item.likeDate }"
							pattern="yyyy-MM-dd" /></td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="nav-shareFriends" role="tabpanel"
		aria-labelledby="nav-shareFriends-tab">
		<form action="">
			<div class="reo mt-3">
				<div class="col">
					<div class="form-inline">
						<div class="form-group">
							<label class="form-label text-white" for="select">Video
								Title:</label> <select class="form-control ml-1 mr-1" name=""
								id="select">
								<option value="">JavaScript</option>

							</select>

							<button type="button" class="btn btn-outline-info">Report</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col mt-3">
					<table class="table table-stripe table-dark">
						<tr>
							<td>Sender Name</td>
							<td>Sender Email</td>
							<td>Receiver Email</td>
							<td>Send Date</td>
						</tr>
						<tr>
							<td>Van Teo</td>
							<td>teo@gmail.com</td>
							<td>voteo@gmail.com</td>
							<td>01-01-2022</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</div>
</div>
