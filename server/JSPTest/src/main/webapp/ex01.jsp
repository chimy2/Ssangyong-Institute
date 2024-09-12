<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex01.jsp -->
	<h1>Hello world!</h1>
	<!-- 
		java로는 web.xml에 경로를 설정해줘야하는데
		jsp는 가상주소 매핑이 필요없이 바로 불러올 수 있다.
	 -->
	 
	 <% 
	 	/*
	 		마치 script나 style 영역을 만든 것과 같다
	 		<script>JavaScript영역</script>
	 		<style>CSS 영역</style>
	 		
	 		↓ 자바 영역
	 	*/	
	 	Calendar now = Calendar.getInstance();
	 %>
	 
	 <div><%= String.format("%tT", now) %></div>
	 
</body>
</html>