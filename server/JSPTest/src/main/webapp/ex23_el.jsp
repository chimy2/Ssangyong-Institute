<%@page import="com.test.java.Student"%>
<%@page import="java.util.HashMap"%>
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
	<!-- ex23_el.jsp -->
	<h1>EL</h1>
	
	<%
		int a = 10;	// 자바 데이터 > 화면 출력
		
		// ***** EL은 평범한 출력문이 아니라, 내장 객체의 컬렉션값들을 출력하는 전용 출력문이다.
		// - pageContext, request, session, application
		//	- setAttribute(key, value) > 이 값들을 출력하는 도구
		
		// EL은 키를 가져올 때 우선순위
		// - pageContext > request > session > application
		// - 생명주기: 한페이지 > forward면 여러페이지 가능 > 페이지에 국한되지 않음 > 더 넓음
		// 생명주기가 짧은 것부터 긴 순서대로 가져옴
		pageContext.setAttribute("b", 20);
		request.setAttribute("c", 30);
		session.setAttribute("d", 40);
		session.setAttribute("b", 200);
		
	%>
	
	<h2>표현식</h2>
	<div>a: <%= a %></div>
	<div>b: <%= pageContext.getAttribute("b") %></div>
	
	<h2>EL</h2>
	<div>a: ${a}</div>	
	<!-- ${pageContext.getAttribute("a")} 로 반환하기 때문에 map에서 null값을 반환하고 따라서 아무런 값도 출력하지 않는다.-->
	<%-- <div>b: ${pageContext.getAttribute("b")}</div> --%>
	<div>b: ${b}</div>
	<div>c: ${c}</div>
	<div>d: ${d}</div>
	<div>session.b: ${session.getAttribute("b")}</div><!-- null -->
	<div>session.b: ${sessionScope.b}</div><!-- 200 -->
	<div>pageContext.b: ${pageScope.b}</div><!-- 20 -->
	<div>request.b: ${requestScope.c}</div><!-- 30 -->
	
	<hr>
	
	<%
		pageContext.setAttribute("n1", 10);
		pageContext.setAttribute("n2", 3);
	%>
	
	<h2>EL 기능</h2>
	<h3>EL 연산 기능</h3>
	
	<div>n1 + 10 = ?</div>
	<div>n1 + 10 = <%= (int)pageContext.getAttribute("n1") + 10 %></div>
	<div>n1 + 10 = ${n1} + 10</div>
	<div>n1 + 10 = ${n1 + 10}</div>
	<div>n1 - 10 = ${n1 - 10}</div>
	<div>n1 * 10 = ${n1 * 10}</div>
	<div>n1 / 10 = ${n1 / 10}</div>
	<div>n1 % 10 = ${n1 % 10}</div>
	<div>n1 mod 10 = ${n1 mod 10}</div><!-- 특정 상황에서 % 연산자를 사용할 시 에러가 날 때 대체해서 사용 -->
	
	<div>n1 + n2 = <%= (int)pageContext.getAttribute("n1") + (int)pageContext.getAttribute("n2") %></div>
	<div>n1 + n2 = ${n1} + ${n2}</div><!-- 잘못된 표현 -->
	<div>n1 + n2 = ${n1 + n2}</div>
	
	<hr>
	
	<!-- tag 기호랑 겹치므로 <> 꺽쇄는 무조건 이스케이프 문자 쓰기 -->
	
	<div>n1 &gt; 0 = ${n1 > 0}</div>
	<div>n1 &lt; 0 = ${n1 < 0}</div>

	<div>n1 &gt;= 0 = ${n1 >= 0}</div>
	<div>n1 &lt;= 0 = ${n1 <= 0}</div>
	
	<div>n1 == 10 = ${n1 == 0}</div>
	<div>n1 != 10 = ${n1 != 0}</div>
	
	<div>n1 &gt; 0 = ${n1 gt 0}</div>
	<div>n1 &lt; 0 = ${n1 lt 0}</div>

	<div>n1 &gt;= 0 = ${n1 ge 0}</div>
	<div>n1 &lt;= 0 = ${n1 le 0}</div>
	
	<div>n1 == 10 = ${n1 eq 0}</div>
	<div>n1 != 10 = ${n1 ne 0}</div>
	
	<hr>
	
	<div>true && true = ${true && true}</div>
	<div>true || false = ${true || false}</div>
	<div>!true = ${!true}</div>
	
	<div>true && true = ${true and true}</div>
	<div>true || false = ${true or false}</div>
	<div>!true = ${not true}</div>
	
	<hr>
	
	<div>${n1 > 0 ? "양수" : "음수"}</div>

	<!-- 권장 -->	
	<%-- <div>${"홍길동".equals("홍길동")}</div> --%>
	
	<!-- 비권장 -->
	<div>${"홍길동" == "홍길동"}</div><!-- 문자열 비교가 대체적으로 == 로 되지만 안되는 경우가 있어서 함수로 쓰는걸 권장함 -->
	
	<hr>
	
	<%
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", "홍길동");
		map.put("age", "20");
		map.put("address", "서울시");
		
		/* 세션을 쓰게 되면 이 예제에서만 사용할건데 계속 남아있게 되므로 최소 pageContext 최대 request에 넣음 */
		request.setAttribute("map", map);
	%>
	<h2>HashMap 객체 출력</h2>
	
	<div>이름: <%= map.get("name") %></div>
	<div>나이: <%= Integer.parseInt(map.get("age")) - 1 %></div>
	<div>주소: <%= map.get("address") %></div>
	
	<div>이름: ${map.get("name")}</div>
	<div>나이: ${map.age - 1}</div>
	<div>주소: ${map["address"]}</div>
	
	<%
		Student s1 = new Student();
	
		s1.setName("아무개");
		s1.setAge(25);
		s1.setAddress("부산시");
		s1.setNum(9);
		
		pageContext.setAttribute("s1", s1);
	%>
	<h2>객체 출력</h2>
	
	<div>이름: <%= s1.getName() %></div>
	<div>나이: <%= s1.getAge() %></div>
	<div>주소: <%= s1.getAddress() %></div>
	<div>숫자: <%= s1.getAddress() %></div>
	
	<div>이름: ${s1.name}</div>
	<div>나이: ${s1.age}</div>
	<div>주소: ${s1.address}</div>
	<!-- 
		Student Class의 num은 private이기 때문에 바로 접근할 수 없지만 
		num으로 쓸 수 있는 것은 el에서 age자체를 가져오는 것이 아니라 getNum()로 가져오기 때문
			
	-->
	
	<%
		Student s2 = null;
		request.setAttribute("s2", s2);
		
		String s3 = "홍길동";
		request.setAttribute("s3", s3);
		request.setAttribute("s3", "");
	%>
	
	<div><%= s2 == null %></div>
	<div>${s2 == null}</div>
	<div>${empty s2}</div>
	
	<div>null: ${s3 == null}</div><!-- false -->
	<div>"": ${s3.equals("")}</div><!-- true -->
	<div>문자열이 없냐?: ${s3 == null || s3.equals("")}</div><!-- true -->
	<div>문자열이 없냐?: ${empty s3}</div><!-- true -->
	<div>문자열이 없냐?: ${empty s4}</div><!-- true -->
	<!-- empty > null과 빈값을 둘다 검사해줌 -->
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>