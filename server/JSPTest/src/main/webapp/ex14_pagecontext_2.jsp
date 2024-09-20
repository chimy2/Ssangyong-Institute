<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String nickParam = request.getParameter("nick");
	Object nickAttr = request.getAttribute("nick");
%>
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
	<!-- ex14_pagecontext_2.jsp -->
	<h1>두번째 페이지</h1>
	
	<div class="message">name: <%= name %></div>	
	<div class="message">nickParam: <%= nickParam %></div>	
	<div class="message">nickAttr: <%= nickAttr %></div>	
	<div class="message">pageContextAttr: <%= pageContext.getAttribute("nick") %></div>	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>