<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/header.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/menu.js"></script>
</head>
<body>
	<header>
		<a href="/" id="logo">
			<img src="http://placehold.it/30x30"/>
		</a>
		<div class="loginbox">
			<c:if test="${userInfo == null}">
				<a id="lgn" href="/member/login">로그인</a>
				<a href="/member/join">회원가입</a>
			</c:if>
			<c:if test="${userInfo != null}">
				<span class="grade">${userInfo.ui_user_grade}</span>
				<a href="/member/detail?ui_seq=${userInfo.ui_seq}" id="username">${userInfo.ui_name }님</a>
				<a href="/member/logout" id="logout_btn">로그아웃</a>
			</c:if>
		</div>
		<nav id="gnb">
			<ul></ul>
		</nav>
	</header>
</body>
</html>