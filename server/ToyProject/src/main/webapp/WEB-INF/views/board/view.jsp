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
	<!-- add.jsp > view.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<div id="main">
		<h1>게시판 <small>상세보기</small></h1>
		
		<form action="/toy/board/add.do" method="POST">
			<table class="vertical" id="view">
				<!-- 
				<tr>
					<th>번호</th>
					<td>10</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>홍길동(hong)</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>제목입니다.</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>내용입니다.</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>2024-10-10 11:00:00</td>
				</tr>
				<tr>
					<th>읽음</th>
					<td>100</td>
				</tr>
				 -->
				<tr>
					<th>번호</th>
					<td>${dto.seq}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${dto.name}(${dto.id})</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${dto.subject}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${dto.content}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${dto.regdate}</td>
				</tr>
				<tr>
					<th>읽음</th>
					<td>${dto.readcount}</td>
				</tr>
			</table>
			<div>
				<button type="button" class="back" onclick="location.href='/toy/board/list.do';">돌아가기</button>
				
				<c:if test="${not empty user}">
					<c:if test="${dto.id == user.id || user.lv == '2'}">
						<button type="button" class="edit" onclick="location.href='/toy/board/edit.do?seq=${dto.seq}';">수정하기</button>			
						<button type="button" class="del" onclick="location.href='/toy/board/del.do?seq=${dto.seq}';">삭제하기</button>			
					</c:if>
					
					<button type="button" class="reply">답변하기</button>			
				</c:if>
			</div>
		</form>
	</div>
	
	<script src="/toy/asset/js/main.js"></script>
	<script>
		
	</script>	
</body>
</html>