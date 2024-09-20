<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 
		서버측 페이지 이동하기
		- response.sendRedirect("URL")
		- pageContext.forward("URL")
		
	*/
	
	// A 페이지 > (이동 + 데이터 전달) > B 페이지
	
	// 웹은 상태관리가 불가능하다. > Stateless
	//- 하나의 페이지에서 사용하던 자원들을 지속적으로 유지해서 
	//		다른 페이지에서도 활용할 수 없다.
	
	// DB > select
	String name = "홍길동";
	String nick = "강아지";
	
	/* System.out.println("시작");
	pageContext.forward("ex14_pagecontext_2.jsp");
	System.out.println("끝"); */
	
	pageContext.setAttribute("num", 100);
	System.out.println(pageContext.getAttribute("num"));
	
	request.setAttribute("num", 200);
	System.out.println(pageContext.getAttribute("num"));
	
	request.setAttribute("nick", nick);
	pageContext.setAttribute("nick", nick);
	
	pageContext.forward("ex14_pagecontext_2.jsp");
	// response.sendRedirect("ex14_pagecontext_2.jsp");
	/* 
		jsp 페이지를 만들기 전에 request, response, pageContext를 만드는데
		임시 페이지를 만들면 쓸모를 다한 만들었던 모든 내장 객체가 소멸한다
		
		단, forward를 사용하면 request, response객체는 
			페이지를 이동해도 자원이 사라지지 않고 그대로 사용한다.
			pageContext는 소멸해서 재생성한다.
	*/
	
	/* 
	
		서버쪽 > 페이지간의 데이터 전달
		1. request 안에 데이터를 넣는다.
		2. pageContext.forward()로 이동한다.
		3. 이동한 페이지의 request 안의 데이터를 꺼낸다. 
		
		pageContext > 생명 주기가 한 페이지 
			 > 다른 페이지로 데이터 전달 불가능
	*/
	
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
	<!-- ex14_pagecontext_1.jsp -->
	<h1>첫번째 페이지</h1>
	
	<div class="message"><%= name %></div>	
	
	<div><a href="ex14_pagecontext_2.jsp?name=<%= name %>">이동하기</a></div>
	
	<form method="POST" action="ex14_pagecontext_2.jsp" id="form1">
		<input type="hidden" name="name" value="<%= name %>">
		<div><a href="#!" id="link1">이동하기</a></div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		document.getElementById('link1').onclick = function() {
			document.getElementById('form1').submit();
		}
	</script>	
</body>
</html>