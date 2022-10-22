<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="col-10 navbar-fixed-top">
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<a class="nav-link active" id="nav-videoEditing-tab" data-toggle="tab"
			href="#nav-videoEditing" role="tab" aria-controls="nav-home"
			aria-selected="true">Video Editing</a> <a class="nav-link"
			id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab"
			aria-controls="nav-profile" aria-selected="false">Videos List</a>
	</div>
</nav>
<div class="col-10 tab-content" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-videoEditing"
		role="tabpanel" aria-labelledby="nav-videoEditing-tab">
		<div class="mt-2">
			<jsp:include page="/lib/common/inform.jsp"></jsp:include>
		</div>
		<form action="VideoManagement" method="post"
			enctype='multipart/form-data'>
			<div class="card bg-dark text-white">
				<div class="card-body">
					<div class="row">
						<div class="col-5">
							<div class="boder p-1">
								<img name="imagePoster" id="frame" src="${video.poster }"
									class="img-fluid" />
								<div class="mb-3">
									<label for="formFile" class="form-label">Poster Video</label> <input
										class="form-control bg-dark text-white" type="file"
										name="cover" id="formFile" accept="image/*"
										onchange="preview()">
								</div>
							</div>
						</div>
						<div class="col-7">
							<div class="form-group">
								<label for="videoIDs">Video ID</label> <input
									value="${video.videoID }" type="hidden"
									class="form-control bg-dark text-white" name="videoID"
									id="videoIDs" aria-describedby="videoIdHid"
									placeholder="ID Video..">
							</div>
							<div class="form-group">
								<label for="videoTitle">Video Title</label> <input type="text"
									value="${video.title }" class="form-control bg-dark text-white"
									name="title" id="videoTitle" aria-describedby="videoTitleHid"
									placeholder="Title Video.."> <small id="videoTitleHid"
									class="form-text text-muted">Video title is required!</small>
							</div>
							<div class="form-group">
								<label for="otherName">Other Name</label> <input type="text"
									value="${video.otherName }"
									class="form-control bg-dark text-white" name="otherName"
									id="otherName" aria-describedby="otherNameHid"
									placeholder="Other Name.."> <small id="otherNameHid"
									class="form-text text-muted">Other name is required!</small>
							</div>
							<div class="form-ground">
								<label for="videoType">Video Type</label> <select
									name="clipType" id="videoType"
									class="selectpicker form-control bg-dark text-white">
									<option value="Country?">Please, Choose type video!</option>
									<c:forEach var="item" items="${videoTypes}">
										<option value="${item.videoTypeID}">${item.name}</option>
									</c:forEach>
								</select>
								<div class="nav-item dropdown col-5 mt-2">
									<a class="nav-link dropdown-toggle btn btn-outline-success"
										href="#" id="dropdownId" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Add Country</a>
									<div class="dropdown-menu bg-secondary"
										aria-labelledby="dropdownId">
										<div class="dropdown-item form-inline my-2 my-lg-0">
											<input name="nameType"
												class="form-control mr-sm-2 bg-dark text-white" type="text"
												placeholder="Name country...">
											<button class="btn btn-outline-info my-2 my-sm-0"
												formaction="insertType">Add</button>
										</div>
									</div>
								</div>
							</div>
							<script>
								var idElement = document
										.getElementById("videoType");
								var result = idElement.options[idElement.selectedIndex].value;
								document.getElementsByName("videoType").innerHTML = result;
							</script>
							<div class="form-ground">
								<label for="country">Country</label> <select name="clipCountry"
									id="country"
									class="selectpicker form-control bg-dark text-white">
									<option value="Country?">Please, Choose country!</option>
									<!-- video.videoCountry != null ? video.videoCountry :  -->
									<c:forEach var="item" items="${videoCountrys}">
										<option value="${item.videoCountryID}">${item.name}</option>
									</c:forEach>
								</select>
								<div class="nav-item dropdown col-5 mt-2">
									<a class="nav-link dropdown-toggle btn btn-outline-success"
										href="#" id="dropdownId" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Add Country</a>
									<div class="dropdown-menu bg-secondary"
										aria-labelledby="dropdownId">
										<div class="dropdown-item form-inline my-2 my-lg-0">
											<input name="insertCountry"
												class="form-control mr-sm-2 bg-dark text-white" type="text"
												placeholder="Name country...">
											<button class="btn btn-outline-info my-2 my-sm-0"
												formaction="insertCountry">Add</button>
										</div>
									</div>
								</div>
							</div>
							<script>
								var e = document.getElementById("country");
								var result = e.options[e.selectedIndex].value;
								document.getElementById("hiddenId").innerHTML = result;
							</script>
							<div class="form-check mt-3">
								<label for="radio-check">Action: </label>
								<div class="radio-check  form-check-inline">
									<label class="ml-5 mr-5"><input type="radio"
										class="form-check-input" value="1" name="action" id="status"
										${video.action == 1 ? 'checked' : '' } checked>Inprogress</label>
									<label><input type="radio" class="form-check-input"
										value="0" name="action" id="status"
										${video.action == 0 ? 'checked' : '' }>Finished</label>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="description">Description</label>
							<textarea name="desCription" id="description" cols="30" rows="4"
								class="form-control bg-dark text-white"
								placeholder="Description...">${video.desCription }</textarea>
						</div>
					</div>
				</div>
				<div class="card-footer text-muted">
					<button formaction="create" class="btn btn-outline-primary">Create</button>
					<button formaction="update" class="btn btn-outline-success">Update</button>
					<button formaction="delete" class="btn btn-outline-danger">Delete</button>
					<button formaction="reset" class="btn btn-outline-info">Reset</button>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-pane fade" id="nav-profile" role="tabpanel"
		aria-labelledby="nav-profile-tab">
		<table class="table table-stripe table-dark text-center">
			<thead>
				<tr>
					<th scope="col">VideoID</th>
					<th scope="col">VideoTitle</th>
					<th scope="col">OtherName</th>
					<th scope="col">Views</th>
					<th scope="col">Description</th>
					<th scope="col">Status</th>
					<th scope="col">Type</th>
					<th scope="col">Country</th>
					<th scope="col">CreateDate</th>
					<th scope="col">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${videos}">
					<tr>
						<td>${item.videoID }</td>
						<td>${item.title }</td>
						<td>${item.otherName }</td>
						<td>${item.views }</td>
						<td>Nội dung phim..</td>
						<td>${item.action == 0 ? 'Finished' : 'Inprogress'}</td>
						<td>${item.videoType.getName() }<%-- <%=(String) request.getAttribute("item.videoType")%> --%>
						</td>
						<td>${item.videoCountry.getName() }</td>
						<td><fmt:formatDate value="${item.createDate }"
								pattern="yyyy-MM-dd" /></td>
						<td><a href="edit?id=${item.videoID }"><i
								class="fa fa-edit" aria-hidden="true"></i>Edit</a> <a
							href="delete?videoID=${item.videoID }"><i class="fa fa-trash"
								aria-hidden="true"></i>Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>