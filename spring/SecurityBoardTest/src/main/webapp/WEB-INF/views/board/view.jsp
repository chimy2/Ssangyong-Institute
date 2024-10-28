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
	<!-- view.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Board <small>view</small></h2>
	
	<table class="vertical">
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><c:out value="${dto.content}"/></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.memberid}</td>
		</tr>
	</table>
	<div>
		<sec:authorize access="isAuthenticated()">
			<button class="edit" onclick="location.href='/spring/board/edit.do?seq=${dto.seq}&id=${dto.memberid}';">수정하기</button>
			<button class="del" onclick="location.href='/spring/board/del.do?seq=${dto.seq}&id=${dto.memberid}';">삭제하기</button>
		</sec:authorize>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>





