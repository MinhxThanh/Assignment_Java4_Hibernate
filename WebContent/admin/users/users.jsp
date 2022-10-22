<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<nav class="col-10 navbar-fixed-top">
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<a class="nav-link active" id="nav-videoEditing-tab" data-toggle="tab"
			href="#nav-videoEditing" role="tab" aria-controls="nav-home"
			aria-selected="true">User Editing</a> <a class="nav-link"
			id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
			aria-controls="nav-profile" aria-selected="false">Users List</a>
	</div>
</nav>
<div class="col-10 tab-content bg-dark" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-videoEditing"
		role="tabpanel" aria-labelledby="nav-videoEditing-tab">
		<div class="mt-2">
			<jsp:include page="/lib/common/inform.jsp"></jsp:include>
		</div>
		<form action="UserManagement" method="post"
			enctype='multipart/form-data'>
			<div class="card bg-dark text-white">
				<div class="card-body">
					<div class="row">
						<div class="col-5">
							<div class="boder p-1">
								<img id="frame" src="${user.image }" class="avatar img-circle img-thumbnail img-fluid rounded-circle mt-5" />
								<div class="mb-3">
									<label for="formFile" class="form-label">Image User</label> <input
										class="form-control bg-dark text-white" type="file"
										name="coverUser" id="formFile" accept="image/*"
										onchange="preview()">
								</div>
							</div>
						</div>
						<div class="col-7">
							<div class="form-group">
								<label for="userID">User ID</label> <input type="hidden"
									class="form-control bg-dark text-white text-center" name="userID"
									id="userID" aria-describedby="userIDHid"
									placeholder="ID User.." value="${user.userID }">
							</div>
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									class="form-control bg-dark text-white" name="username"
									id="username" aria-describedby="usernameHid"
									placeholder="Username.." value="${user.username }"> <small
									id="usernameHid" class="form-text text-muted">Username
									is required!</small>
							</div>
							<div class="form-group">
								Password <label for="password">Password</label> <input
									type="password" class="form-control bg-dark text-white"
									name="password" id="password" aria-describedby="passwordHid"
									placeholder="Password.." value="${user.password }"> <small
									id="passwordHid" class="form-text text-muted">Other
									name is required!</small>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control bg-dark text-white"
									id="exampleInputEmail1" name="email"
									aria-describedby="emailHelp" placeholder="Enter email"
									value="${user.email }"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-ground">
								<label for="country">Country</label> <select name="country"
									id="country"
									class="selectpicker form-control bg-dark text-white">
									<option value="Country?">Please, Choose country!</option>
									<c:forEach var="item" items="${videoCountrys}">
										<option value="${item.name}">${item.name}</option>
									</c:forEach>
								</select>
								<div class="nav-item dropdown col-4 mt-2">
									<a class="nav-link dropdown-toggle btn btn-outline-success"
										href="#" id="dropdownId" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Add Country</a>
									<div class="dropdown-menu bg-secondary"
										aria-labelledby="dropdownId">
										<div class="dropdown-item form-inline my-2 my-lg-0">
											<input class="form-control mr-sm-2 bg-dark text-white"
												type="text" placeholder="Name country..."
												name="inserCountry">
											<button formaction="insertCountryUser"
												class="btn btn-outline-info my-2 my-sm-0">Add</button>
										</div>
									</div>
								</div>
							</div>
							<div class="form-check mt-3">
								<!-- 								 <label class="ml-2" for="radio-check">Role: </label>
 -->
								<div class="radio-check  form-check-inline">
									<label><input type="radio" class="form-check-input"
										value="0" name="role" id="status">User</label> <label
										class="ml-5 mr-5" ${user.role == 0 ? 'checked' : '' }>
										<!-- <input
											type="radio" class="form-check-input" value="1" name="role"
											id="status">Employer</label>
											<label> --> <input type="radio" class="form-check-input"
										value="1" name="role" id="status"
										${user.role == 1 ? 'checked' : '' }>Manager
									</label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					<button formaction="createUser" class="btn btn-outline-primary">Create</button>
					<button formaction="updateUser" class="btn btn-outline-success">Update</button>
					<button formaction="deleteUser" class="btn btn-outline-danger">Delete</button>
					<button formaction="resetUser" class="btn btn-outline-info">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="nav-profile" role="tabpanel"
		aria-labelledby="nav-profile-tab">
		<table class="table table-stripe table-dark text-center">
			<thead>
				<tr>
					<th scope="col">UserID</th>
					<th scope="col">Username</th>
					<th scope="col">Email</th>
					<th scope="col">CreateDate</th>
					<th scope="col">Country</th>
					<th scope="col">Role</th>
					<th scope="col">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${users}">
					<tr>
						<td>${item.userID }</td>
						<td>${item.username }</td>
						<td>${item.email }</td>
						<td>
							<fmt:formatDate value="${item.createDate }"
								pattern="yyyy-MM-dd" />
						</td>
						<td>${item.country }</td>
						<td>${item.role == 0 ? 'User' : 'Manager'}</td>
						<td><a href="editUser?id=${item.userID }"><i
								class="fa fa-edit" aria-hidden="true"></i>Edit</a> <a
							href="deleteUser?id=${item.userID }"><i class="fa fa-trash"
								aria-hidden="true"></i>Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
