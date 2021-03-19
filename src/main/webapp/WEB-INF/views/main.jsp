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
	<title>Community Site</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/main.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
</head>
<body>
	<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	
	<div class="main">
		<section class="s1">
			<div class="notice">
				<div class="notice_header">
					<p>공지사항</p>
					<a href="/notice">more</a>
				</div>
				<div class="notice_contents">
					<c:forEach items="${noticeList }" var="notice">
						<a href="/notice/detail?no=${notice.pi_seq }&post=${notice.no}" class="notice_item">
							<span class="title">
								<i class="far fa-clipboard"></i> ${notice.pi_title }
							</span>
							<span class="date">
								<fmt:formatDate value="${notice.pi_reg_dt }" pattern="yyyy-MM-dd HH:mm" />
							</span>
						</a>
					</c:forEach>
				</div>
			</div>
		</section>
	</div>

			<div class="notice">
				<div class="notice_header">
					<p>주식게시판</p>
					<a href="/stock">more</a>
				</div>
				<div class="notice_contents">
					<c:forEach items="${stockList }" var="stock">
						<a href="/stock/detail?no=${stock.pi_seq }&post=${stock.no}" class="notice_item">
							<span class="title">
								<i class="far fa-clipboard"></i> ${stock.pi_title }
							</span>
							<span class="date">
								<fmt:formatDate value="${stock.pi_reg_dt }" pattern="yyyy-MM-dd HH:mm" />
							</span>
						</a>
					</c:forEach>
				</div>
			</div>

	<footer>
	
	</footer>
</body>
</html>