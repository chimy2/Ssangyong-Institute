<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 
		클라이언트 > (전송 데이터) > 서버
		- request 객체 담당
		- String request.getParameter(String key)
			- GET, POST 모두 동일하게 수신
			
		1. GET
			- URL 뒤에 데이터를 붙여서 전송 > 편법
			- 택배 상자 겉의 송장에 데이터를 추가해서 전송
			- ex08_ok.jsp?name=홍길동&age=20
			- 쿼리 스트링(Query String)
			- 모든 요청은 톰캣이 받고 톰캣은 데이터가 아니라 주소를 받은 걸로 인식
			- 톰캣의 인코딩 > UTF-8
			
		2. POST
			- 패킷 본문(body) 안에 넣어서 전송 > 정석
			- 택배 상자 안에 데이터를 넣어서 전송
			- ex08_ok.jsp
			- post로 받았을 때 인코딩이 나간 이유? 
				> 웹에서 데이터를 송수신할 때 기본 인코딩 > ISO-8859-1(EUC-KR과 유사)
			- ISO-8859-1 > (변환) > UTF-8
	*/
	
	//<div>이름: <input type="text" name="name"></div>
	//<div>나이: <input type="text" name="age"></div>
	
	// 클라이언트에서 보낸 데이터를 UTF-8로 인코딩
	// 중간까지는 그대로 받고 나중에 인코딩 설정을 해서 받고 싶다고 중간에 설정한다고 해도
	// 어차피 처음에 세팅된 인코딩밖에 안먹기 때문에 request 사용 전에 인코딩 설정 필요
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
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
	<!-- ex08_ok.jsp -->
	<h1>결과</h1>
	
	<div>이름: <%= name %></div>
	<div>나이: <%= age %></div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>