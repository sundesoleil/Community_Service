<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문제신고</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/write.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/write.css">
	<script>
		<c:if test="${userInfo == null}" >
			alert("로그인 후 작성하실 수 있습니다.")
			location.href="/member/login";
		</c:if>
		let boardseq = "${boardSeq}";
	</script> 
</head>
<body>
	<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<h1>[문제신고게시판] 글쓰기</h1>	
		<div class="title_area" data-user-seq="${userInfo.ui_seq }">
			<span>제목</span>
			<input type="text" id="post_title">
		</div>
		<div class="content_area">
			<textarea id="post_content"></textarea>
		</div>
		<div class="btn_area">
			<button id="post_save">등록</button>
			<button id="post_cancel">취소</button>
		</div>
	</div>
</body>
</html>