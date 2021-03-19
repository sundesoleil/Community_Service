<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must_revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>커뮤니티:사용자정보</title>
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/user_detail.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%@include file = "/WEB-INF/views/includes/header.jsp" %>
	<div class="content_wrap">
		<div class="userInfo">
			<div class="profile_img">
				<img src="http://placehold.it/200x200">
				<button>사진변경</button>
			</div>

			<div class="profile_info">
				
				<div>
					<span class="user_label">${user_detail.ui_user_grade}</span>
					<span class="user_id">${user_detail.ui_name } (${user_detail.ui_id })</span>
					<span class="item_label"><i class="fas fa-user-alt"></i> 유형</span>
					<span class="item_content"> 
						<c:if test="${user_detail.ui_user_type == 1 }">관리자</c:if>
						<c:if test="${user_detail.ui_user_type == 2 }">정회원</c:if>
						<c:if test="${user_detail.ui_user_type == 3 }">준회원</c:if>
						<c:if test="${user_detail.ui_user_type == 4 }">가입대기</c:if>
					</span>
					<span class="label"><i class="far fa-envelope"></i> 이메일</span>
					<span class="item_content">
						<a href="#">${user_detail.ui_email}</a>
					</span>
				</div>
				<div>
					<span class="item_label"><i class="fas fa-blog"></i> 블로그</span>
					<span class="item_content">
						<c:if test="${user_detail.ui_blog != null}">
							<a href="${user_detail.ui_blog}">${user_detail.ui_blog}</a>
						</c:if>
						<c:if test="${user_detail.ui_blog == null}">
							<span>블로그 정보가 없습니다</span>
						</c:if>
					</span>
				</div>
				<div>
					<span class="item_label"><i class="fas fa-edit"></i> 작성 게시글 수</span>
					<span class="item_content">${postCnt}</span>
					<span class="item_label"><i class="fas fa-thumbs-up"></i> 좋아요</span>
					<span class="item_content">${likeCnt }</span>
					<span class="item_label"><i class="fas fa-thumbs-down"></i> 싫어요</span>
					<span class="item_content">${dislikeCnt }</span>
				</div>
				<textarea disabled>
					<c:if test="${user_detail.ui_introduce == null }">등록된 자기소개가 없습니다.</c:if>
					<c:if test="${user_detail.ui_introduce != null }">${user_detail.ui_introduce }</c:if>
				</textarea>
				<button id="modify">정보수정</button>
			</div>
		</div>
		<div class="user_introduce">
		
		</div>
	</div>
</body>
</html>