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
	<title>QNA</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/qna_list.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/board.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<script>
		let board_seq = "${board_seq}"
	</script>
</head>
<body>
<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<h1>문의게시판</h1>
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
						<td>${post.pi_seq}</td>
						<td>문의</td>
						<td><a href="/qna/detail?no=${post.pi_seq }">${post.pi_title }</a></td>
						<td><fmt:formatDate value="${post.pi_reg_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>${post.pi_count }</td>
					</tr>
					</c:forEach>
				</c:if>
				
			</tbody>
		</table>
			<a href="/qna/write?seq=2" id="notice_write">등록</a>

		<div class="pager_area">
			<button id="prev_10"><i class="fas fa-angle-double-left"></i></button>
			<button id="prev_page"><i class="fas fa-chevron-left"></i></button>
			<div class="pagers">

			</div>
			<button id="next_page"><i class="fas fa-chevron-right"></i></button>
			<button id="next_10"><i class="fas fa-angle-double-right"></i></button>
		</div>
		<div class="search_area">
			<select>
				<option value="all">전체</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="author">작성자</option>
			</select>
			<input type="text" id="search_keyword">
			<button id="search_btn">검색</button>
		</div>
	</div>
</body>
</html>