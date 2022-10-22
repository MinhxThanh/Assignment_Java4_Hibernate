<%@page import="poly.dao.AnCommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="poly.model.AnConmment"%>
<%@page import="poly.dao.AnCommentDao"%>
<%@page import="java.util.List"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://momentjs.com/downloads/moment.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/emojionearea/3.4.1/emojionearea.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/emojionearea/3.4.1/emojionearea.min.js"></script>

<c:forEach var="item" items="${commentUser }">
	<div class="main-comment">
		<div class="col-12 bg-dark rounded-2 p-2 mt-2">
			<div class="float-left image mt-2  mr-1">
				<img src="${item.image }" width="50px"
					class="rounded-circle avatar border border-light"
					alt="user profile image">
			</div>
			<div class="commentContent ml-1 position-relative">
				<h6 id="dayComment"
					class="momentComment text-secondary time position-absolute top-0 end-0"
					style="font-size: 10px">
					<script>
						document.write(moment("${item.createDate }").fromNow());
					</script>
				</h6>
				<c:if test="${not empty sessionScope.user }">
					<c:if test="${sessionScope.email == item.user.email }">
						<div class="position-absolute bottom-0 end-0">
							<form action="Category" method="get">
								<button class="btn text-secondary" name="commentID"
									style="font-size: 10px" formaction="categoryRemoveComment"
									value="${item.commentID }">Remove</button>
							</form>
						</div>
					</c:if>
				</c:if>
				<span class="text-danger">${item.title }</span>
				<hr class="text-secondary ml-5 mt-2" />
				<div class="text-white ml-5">${item.content }</div>
			</div>
			<button type="submit" class="btn text-white ml-4 mt-2 pt-1 pb-1"
				style="font-size: 13px;"
				onclick="document.getElementById('comment-form-${item.commentID }').style.display = 'block'"
				ondblclick="document.getElementById('comment-form-${item.commentID }').style.display = 'none'">Reply</button>
		</div>
		<div class="mt-2 ml-3" id="comment-form-${item.commentID }"
			style="display: none;">
			<form action="categoryAnComment" method="post">
				<div class="col-12 text-white">
					<textarea class="form-control bg-dark" placeholder="Search"
						aria-label="Comment.." name="contentAnComment" rows="2"
						id="textComment-${item.commentID }"></textarea>
					<button type="submit" class="btn-comment btn btn-danger mt-2"
						value="${item.commentID }" name="commentAnID">Send</button>
				</div>
			</form>
		</div>
	</div>
	<div class="an-comment">
		<script>
			var sql = "SELECT * FROM AnConmment WHERE VideoID = " + ${commentAnVideoID} + " and CommentID = " + ${item.commentID} + "";
			moon.dbUtil.doSQLExcute(sql, [], function (data) {
				consolog.log(datas.rows.length)
				document.write(datas.rows.length);

			}
		</script>
	</div>
	<script>
		$("#textComment-${item.commentID }").emojioneArea({
			pickerPosition : "bottom"
		})
	</script>
</c:forEach>

<%-- <div class="an-comment">
		<div class="col-12 bg-dark rounded-2 p-2 mt-2">
			<div class="float-left image mt-2  mr-1">
				<img src="${anCommnetList.image }" width="50px"
					class="rounded-circle avatar border border-light"
					alt="user profile image">
			</div>
			<div class="commentContent ml-1 position-relative">
				<h6 id="dayComment"
					class="momentComment text-secondary time position-absolute top-0 end-0"
					style="font-size: 10px">
					<script>
						document.write(moment("${anCommnetList.createDate }").fromNow());
					</script>
				</h6>
				<c:if test="${not empty sessionScope.user }">
					<c:if test="${sessionScope.email == anCommnetList.user.email }">
						<div class="position-absolute bottom-0 end-0">
							<form action="Category" method="get">
								<button class="btn text-secondary" name="commentID"
									style="font-size: 10px" formaction="categoryRemoveComment"
									value="${anCommnetList.commentID }">Remove</button>
							</form>
						</div>
					</c:if>
				</c:if>
				<span class="text-danger">${anCommnetList.title }</span>
				<hr class="text-secondary ml-5 mt-2" />
				<div class="text-white ml-5">${anCommnetList.content }</div>
			</div>
			<button type="submit" class="btn text-white ml-4 mt-2 pt-1 pb-1"
				style="font-size: 13px;"
				onclick="document.getElementById('comment-form-${anCommnetList.commentID }').style.display = 'block'"
				ondblclick="document.getElementById('comment-form-${anCommnetList.commentID }').style.display = 'none'">Reply</button>
		</div>
		<div class="mt-2 ml-3" id="comment-form-${anCommnetList.commentID }"
			style="display: none;">
			<form action="categoryAnComment" method="post">
				<div class="col-12 text-white">
					<textarea class="form-control bg-dark" placeholder="Search"
						aria-label="Comment.." name="contentAnComment" rows="2"
						id="textComment-${anCommnetList.commentID }"></textarea>
					<button type="submit" class="btn-comment btn btn-danger mt-2"
						value="${anCommnetList.commentID }" name="commentAnID">Send</button>
				</div>
			</form>
		</div>
	</div> --%>

		<!-- <script>
			var redirectUrl = 'Category';

			//using jquery to post data dynamically
			var form = $('<form action="' + redirectUrl + '" method="get">'
					+ '<input type="text" name="commentIDtest" value="'
					+ ${item.commentID } + '" />'
					+ '</form>');
			/* $('body').append(form); */
			form.submit();
		</script> -->

<%-- <c:if test="${not empty sessionScope.user }">
								
</c:if> --%>
<%-- ?commentID=${item.commentID }
 --%>
<!-- style="top: -35%; left: 98.5%;" -->