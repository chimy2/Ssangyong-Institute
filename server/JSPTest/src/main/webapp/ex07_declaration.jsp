<%@page import="com.test.java.MyMath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 변수의 종류?
	int a = 10;// 지역 변수
	
	// 메소드 안의 메소드 선언 > 불가능
	/* public int sum(int a, int b) {
		return a + b;
	} */
%>

<%!
	// 아까 봤던 service 메소드영역이 아님
	int c = 30;
	
	public int sum(int a, int b) {
		return a + b;
	}
	// service 메소드 영역안에 선언되는 것이 아니라서 멤버 변수와 멤버 메소드를 만들 수 있음
	// 멤버 변수는 지역 변수와 비교해서 달리 이점이 없기 때문에 선언을 잘하지 않음
	// 멤버 메소드도 다른 페이지에서 호출하지 못해서 실효성이 없음
	// jsp는 우리가 따로 객체를 만들 일이 없다 > class 이름을 모르기 때문에 인스턴스를 만들 수가 없음
	// 멤버 메소드 > 현재 JSP 페이지 외부에서 사용 불가능(물리적으로는 가능하나 실상은 불가능)
	// 다른 방법 존재
%>
<!DOCTYPE html>
<html>
<head>
	<% 
		System.out.print(a);
		/* 스클립틀릿을 연다고 해서 영역이 다른게 아니라
		서비스 메소드 안, 즉 같은 영역에 선언되고 실행된다. */
		int b = 20;	// a와 같은 영역내의 지역변수(_jspService 메소드)
	%>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- ex07_declaration.jsp -->
	<h1>연산 결과</h1>
	
	<div>10 + 20 = 30</div>
	<div>a + b = 30</div>
	<div><%= a %> + <%= b %> = <%= a + b %></div>
	<!-- 어려운 작업이라고 치고 메소드로 선언하고 싶음 -->
	<div><%= a %> + <%= b %> = <%= sum(a, b) %></div>
	<% 
		MyMath m = new MyMath();
	%>
	<div>a + b = <%= m.sum(a, b) %></div>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>