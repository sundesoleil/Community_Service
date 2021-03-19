<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
 %>
<!-- uri:uniform resource instance -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Community Notice</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/board.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/board.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<script>
		console.log("${list.size()}")
		let board_seq = "${board_seq}"
		let board_name = "notice";
	</script>
</head>
<body>
	<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<h1>공지사항</h1>
		<table class="board_table">
			<thead>
				<tr>
					<th>번호</th>
					<th>유형</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:if test = "${list.size() ==0 }">
					<tr>
						<td colspan="5">등록된 글이 없습니다</td>
					</tr>
				</c:if>
				<c:if test = "${list.size() > 0 }">
					<c:forEach items="${list }" var="post">
					<tr>
						<td>${post.no}</td>
						<td>공지</td>
						<td><a href="/notice/detail?no=${post.pi_seq }&post=${post.no}">${post.pi_title }</a></td>
						<td><fmt:formatDate value="${post.pi_reg_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>${post.pi_count }</td>
					</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
		<c:if test="${userInfo.ui_user_type == 1}">
			<a href="/notice/write?seq=1" id="notice_write">공지등록</a>
		</c:if>
		<div class="pager_area">
			
			<button id="prev_10"><i class="fas fa-angle-double-left"></i></button>
		
			<div class="pagers">

			</div>

			<button id="next_10"><i class="fas fa-angle-double-right"></i></button>
		</div>
		<div class="search_area">
			<form action="/notice">
				<select name="type">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="author">작성자</option>
				</select>
				<input type="text" id="search_keyword" name="keyword">
				<button id="search_btn" type="submit">검색</button>
			</form>
		</div>
	</div>

</body>
</html>