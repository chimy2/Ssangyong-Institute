<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- edit.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Board <small>add</small></h2>
	
	<form method="POST" action="/spring/board/editok.do">
		<table class="vertical">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required class="full" value="${dto.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" required class="full">${dto.content}</textarea></td>
			</tr>
		</table>
		<!-- CSRF 토큰을 넘기지 않으면 본인인지 체크해주는것, 포스트로 넘길 때 필수 -->
		<input type="hidden" name="seq" value="${dto.seq}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="memberid" value="<sec:authentication property="principal.username"/>">
		<div>
			<button class="in">수정하기</button>
		</div>
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>





