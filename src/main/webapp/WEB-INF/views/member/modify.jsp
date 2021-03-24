<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>커뮤니티:정보수정</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<style>
		.cert_area {padding-top:100px;}
	</style>
	<script>
		<c:if test="${userInfo == null}">
			location.href="/";
		</c:if>
	</script>
</head>
<body>
	<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	
	<div class="cert_area">
		<h1>정보수정</h1>
		<form action="/member/cert" method="post">
			<input hidden name="user_id" type="text" value="${userInfo.ui_id }">
			<span>비밀번호</span><input type="password" name="user_pwd">
			<button type="submit" id="cert_submit">확인</button>
		</form>
	</div>
</body>
</html>