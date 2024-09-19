<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- ex04_scriptlet.jsp -->
	<h1>구구단</h1>
	
	<%
		//스크립틀릿 > HTML 문서내에서 자바 영역을 제공
		int dan = 5;
	%>
	
	<%
		// 언어가 여러가지 얽혀있는 것 > 스파게티 코드
		for (int i=1; i<=9; i++) {
			//<div>5 x 1 = 5</div>
			System.out.println("<div>5 x 1 = 5</div>");
	%>
		<!-- 내부 영역 반복 -->
		<div><%= dan %> x <%= i %> = <%= dan * i %></div>
		<%= "<div>" + dan + " x " + i + " = " + (dan * i) + "</div>" %>
	<%
		}
	%>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>