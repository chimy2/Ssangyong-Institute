<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<!-- /spring/logout.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Member <small>logout</small></h2>
	
	<form method="POST" action="/spring/member/logout.do">
		<!-- CSRF 토큰을 넘기지 않으면 본인인지 체크해주는것, 포스트로 넘길 때 필수 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<div>
			<button class="out">로그아웃</button>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>





