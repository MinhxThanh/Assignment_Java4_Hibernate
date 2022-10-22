<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
</div>