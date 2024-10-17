<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	<!-- ex05.jsp -->
	<h1>입력</h1>
	
	<!-- 
		contextroot가 web이 된 이유? 
		> Spring laga프로젝트를 만들때
	 -->
	<h2>ex05ok.do</h2>
	
	<form action="ex05ok.do" method="POST">
		<div>
			<input type="text" name="data">
			<!-- <input type="text" name="num"> -->
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
	</form>
	
	<hr>
	
	<h2>ex05ok1.do</h2>
	
	<form action="ex05ok1.do" method="POST">
		<div>
			<input type="text" name="name">
		</div>
		<div>
			<input type="text" name="age">
		</div>
		<div>
			<input type="text" name="address">
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
		<input type="hidden" name="seq" value="10">
	</form>
	
	<hr>
	
	<h2>ex05ok2.do</h2>
	
	<form action="ex05ok2.do" method="POST">
		<div><input type="checkbox" name="cb" value="java"> 자바</div>
		<div><input type="checkbox" name="cb" value="python"> 파이썬</div>
		<div><input type="checkbox" name="cb" value="basic"> 베이직</div>
		<div><input type="submit" value="보내기"></div>
		<input type="hidden" name="seq" value="10">
	</form>
	
	<hr>
	
	<h2>ex05ok3.do</h2>
	
	<form action="ex05ok3.do" method="POST">
		<div>
			data: 
			<input type="text" name="data">
		</div>
		<div>
			name: 
			<input type="text" name="name">
		</div>
		<div>
			age: 
			<input type="text" name="age">
		</div>
		<div>
			address: 
			<input type="text" name="address">
		</div>
		<div>
			<input type="submit" value="보내기">
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




