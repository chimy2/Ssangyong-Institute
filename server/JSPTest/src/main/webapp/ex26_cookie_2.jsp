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
	<!-- ex26_cookie_2.jsp -->
	<h1>두번째 페이지</h1>
	
	<div id="div1"></div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>	
	<script src="js/cookie.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		$('#div1').text(getCookie("name"));
	</script>	
</body>
</html>