<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/emojionearea/3.4.1/emojionearea.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/emojionearea/3.4.1/emojionearea.min.js"></script>
<style>
.emojionearea .emojionearea-editor{
	color: #fff !important;
</style>

<form action="categoryComment" method="post">
	<div class="col-12 text-white">
		<textarea class="form-control bg-dark" placeholder="Search"
			aria-label="Comment.." name="contentComment" id="textComment"></textarea>
		<button type="submit" class="btn-comment btn btn-danger mt-2">Send</button>
	</div>
</form>
<script>
	$("#textComment").emojioneArea({
		pickerPosition : "bottom"
	})
</script>
