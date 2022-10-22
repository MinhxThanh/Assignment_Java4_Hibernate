<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-11 mt-3 mb-3 mx-auto">
	<form action="Editprofile" method="post" enctype='multipart/form-data'>
		<div class="row bg-dark text-white rounded">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img id="frame" src="${user.image }"
						class="avatar img-circle img-thumbnail img-fluid rounded-circle mt-5" />
					<div class="mb-3">
						<label for="formFile" class="form-label">Image User</label> <input
							class="form-control bg-dark text-white" type="file" name="coverUser"
							id="formFile" accept="image/*" onchange="preview()">
					</div>
					<span class="font-weight-bold">${user.username }</span><span
						class="text-secondary">${user.email }</span><span> </span>
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<h4 class="text-right">Profile Settings</h4>
					</div>
					<div class="row">
						<jsp:include page="/lib/common/inform.jsp"></jsp:include>
					</div>
					<div class="row mt-2">
						<div class="form-group">
							<input type="hidden" value="${user.userID }"
								class="form-control bg-dark text-white" name="123" id="userID"
								aria-describedby="userIDHid" placeholder="User ID..">
						</div>
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								value="${user.username }"
								class="form-control bg-dark text-white" name="username"
								id="username" aria-describedby="usernameHid"
								placeholder="Username..">
						</div>
					</div>
					<div class="form-group">
						<label for="email">Email</label> <input disabled type="text"
							value="${user.email }" class="form-control bg-dark text-white"
							name="email" id="email" aria-describedby="emailHid"
							placeholder="Email..">
					</div>
					<div class="form-group">
						<label for="createDate">Create date</label> <input disabled
							value="${user.createDate }" type="text"
							class="form-control bg-dark text-white" name="createDate"
							id="createDate" aria-describedby="createDateHid"
							placeholder="01-01-2022">
					</div>
					<div class="form-group">
						<label for="country">Country</label> <select name="country"
							id="country" class="selectpicker form-control bg-dark text-white">
							<option value="Country?">Please, Choose country!</option>
							<c:forEach var="item" items="${videoCountrys}">
								<option value="${item.name}">${item.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mt-5 text-center">
						<button class="btn btn-primary profile-button" type="submit">Save
							Profile</button>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="p-3 py-5">

					<ul class="list-group">
						<li class="list-group-item bg-secondary text-muted">Activity
							<i class="fa fa-dashboard fa-1x"></i>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center bg-dark text-white">
							Shares <span class="badge bg-secondary rounded-pill">2</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center bg-secondary text-white">
							Favorite <span class="badge bg-dark rounded-pill">2</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center bg-dark text-white">
							Comment <span class="badge bg-secondary rounded-pill">1</span>
						</li>
					</ul>

				</div>
			</div>
		</div>
	</form>
</div>