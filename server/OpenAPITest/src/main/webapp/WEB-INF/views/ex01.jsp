<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		table td:nth-child(1) {
			width: 120px;
			text-align: center;
		}
		
		table td:nth-child(2) div {
			margin-bottom: 5px;
		}
		
		table img {
			width: 110px;
		}
	</style>
</head>
<body>
	<!-- ex01.jsp -->
	<h1 class="main">Naver Book <small>search</small></h1>
	
	<form action="/api/ex01.do" method="GET">
		<div class="message">
			<div class="group">
				<label>검색어</label>
				<input type="text" name="word" class="long" required
					value="${word}">
				&nbsp;
				<input type="submit" value="검색하기">
				<input type="button" value="초기화" onclick="location.href='/api/ex01.do';">
				&nbsp;
				<!-- 
					모든 블럭 태그는 사이의 공백을 무시하나 
					&nbsp;는 일부러 준 공백이므로 글자 취급을 해서 밀려남
				 -->
				<select name="count" id="count">
					<option value="5">5개씩 보기</option>
					<option value="10" selected>10개씩 보기</option>
					<option value="20">20개씩 보기</option>
					<option value="100">100개씩 보기</option>
				</select>
			</div>
		</div>
		<div>
			<input type="button" value="이전 ${count}개" id="btnPrev">
			<input type="button" value="다음 ${count}개" id="btnNext">
		</div>
		<input type="hidden" name="start" id="start">
	</form>
	
	<table>
		<!-- 
		<tr>
			<td>책표지</td>
			<td>
				<div>제목</div>			
				<div>저자</div>			
				<div>가격</div>			
				<div>출판사</div>			
			</td>
		</tr> 
		-->
		<c:forEach var="dto" items="${list}">
			<tr>
				<td><img src="${dto.image}"></td>
				<td>
					<div>${dto.title}</div>			
					<div>${dto.author}</div>			
					<div>${dto.discount}</div>			
					<div>${dto.publisher}</div>			
				</td>
			</tr> 
		</c:forEach>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		$('#count').val(${count});	
		
		$('#count').change(() => {
			$('input[type=submit]').click();
		});
		
		<c:if test="${not empty word}">
		
		$('#btnPrev').click(() => {
			let start = parseInt($('#start').val()) - parseInt($('#count').val());
			
			if(start < 1) {
				start = 1;
			}
			
			$('#start').val(start);
			$('input[type=submit]').click();
		});
		
		$('#btnNext').click(() => {
			// $('#start').val() + ${count};
			console.log(typeof $('#start').val());
			console.log(typeof $('#count').val());
			let count = parseInt($('#count').val());
			
			let start = parseInt($('#start').val()) + count;
			
			let end = start + count - 1;
			console.log(end);
			if(end > ${total}) {
				start = ${total} - count + 1;
				
				if(start < 1) {
					start = 1;
				}
			}
			
			$('#start').val(start);
			$('input[type=submit]').click();
		});
		
		</c:if>

		<c:if test="${empty start}">
			$('#start').val(1);
		</c:if>
		<c:if test="${not empty start}">
			$('#start').val(${start});
		</c:if>
	</script>	
</body>
</html>