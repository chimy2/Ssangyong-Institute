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
	<!-- ex01.jsp -->
	<h1>Ex01</h1>
	
	<!-- 
	
		request.getParameter(key) > GET방식으로 클라이언트가 보낸 데이터를 가져오는 것 > link?num=100&txt=홍길동
		request.getAttribute(key) > Collection 안에 든 것을 꺼내는것
	
	 -->
	
	<div>num: <%= request.getAttribute("num") %></div>
	
	<div>txt: ${txt}</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>