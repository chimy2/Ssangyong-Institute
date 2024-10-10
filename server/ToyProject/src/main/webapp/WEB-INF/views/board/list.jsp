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
	<!-- list.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<div id="main">
		<h1 class="page">
			게시판 
			<small>
				<c:if test="${map.search == 'n'}">
					목록보기
				</c:if>
				<c:if test="${map.search == 'y'}">
					검색하기
				</c:if>
			</small>
		</h1>

		<c:if test="${map.search == 'y'}">		
			<div id="labelSearchResult">
				'${map.word}'(으)로 검색한 결과로 총 ${list.size()}건 찾았습니다.
			</div>
		</c:if>
		
		<table id="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>읽음</th>
			</tr>
			<!-- 
			<tr>
				<td>10</td>
				<td>게시판입니다.</td>
				<td>홍길동</td>
				<td>2024-10-10</td>
				<td>20</td>
			</tr>
			 -->
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.seq}</td>
					<td>
						<a href="/toy/board/view.do?seq=${dto.seq}">${dto.subject}</a>
						<c:if test="${dto.isnew < 1}">
							<span class="isnew">new</span>
						</c:if>
					</td>
					<td>${dto.name}</td>
					<td>${dto.regtime}</td>
					<td>${dto.readcount}</td>
				</tr>
			</c:forEach>
		</table>
		
		<!-- 검색 인터페이스 -->
		<form id="searchForm" method="GET" action="/toy/board/list.do">
			<!-- 검색의 정확도 증가, DB(오라클) 부담 감소 -->
			<select name="column">
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="name">이름</option>
				<option value="all">제목/내용/이름</option>
			</select>
			<input type="text" name="word" class="long" required>
			<input type="submit" value="검색하기">
		</form>
		
		<c:if test="${not empty user}">
			<div>
				<button type="button" class="add primary" 
					onclick="location.href='/toy/board/add.do';">쓰기</button>
			</div>
		</c:if>
	</div>
	
	<script src="/toy/asset/js/main.js"></script>
	<script>
		<c:if test="${map.search == 'y'}">
			$('#searchForm select[name=column]').val('${map.column}');
			$('#searchForm input[name=word]').val('${map.word}');
		</c:if>
	</script>	
</body>
</html>