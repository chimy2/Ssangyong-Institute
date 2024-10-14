<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@include file="/WEB-INF/views/inc/asset.jsp" %>
	<style>
		
	</style>
</head>
<body>
	<!-- add.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<div id="main">
		<h1>게시판 
			<c:if test="${mode == 'new'}">
				<small>글쓰기</small>
			</c:if>
			<c:if test="${mode == 'reply'}">
				<small>답변하기</small>
			</c:if>
		</h1>
		
		<form action="/toy/board/add.do" method="POST" enctype="multipart/form-data">
			<table class="vertical">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" id="subject" required class="full"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" required class="full"></textarea></td>
				</tr>
				<tr>
					<th>장소</th>
					<td><input type="file" name="attach" id="attach" class="full" accept="image/*"></td>
				</tr>
			</table>
			<div>
				<button type="button" class="back" onclick="location.href='/toy/board/list.do';">돌아가기</button>
				<button type="submit" class="add primary">쓰기</button>			
			</div>
			<input type="hidden" name="mode" value="${mode}">
			<input type="hidden" name="thread" value="${thread}">
			<input type="hidden" name="depth" value="${depth}">
		</form>
	</div>
	
	<script>
		
	</script>	
</body>
</html>