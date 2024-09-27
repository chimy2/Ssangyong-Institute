<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		#item1 { background-color: tomato; }
		#item2 { background-color: gold; }
		#item3 { background-color: cornflowerblue; }
		#item4 { background-color: yellowgreen; }
		
		.item {
			margin: 10px;
			padding: 5px;
			text-align: right;
			padding-right: 15px;
			border-left: 7px solid #555;
			border-top-right-radius: 7px;
			border-bottom-right-radius: 7px;
		}
		
		.item > span:last-child {
			font-size: 12px;
			background-color: #FFF;
			border-radius: 50%;
			padding: 5px;
			margin-left: 5px;
		
		}
	</style>
</head>
<body>
	<!-- ex02.jsp -->
	<h1>설문 조사</h1>
	
	<table class="content" id="table1">
		<!-- <tr>
			<th>제목</th>
		</tr>
		<tr>
			<td>항목(5)</td>
		</tr> -->
		<tr>
			<th></th>
		</tr>
		<tr>
			<td><span></span>(<span></span>)</td>
		</tr>
		<tr>
			<td><span></span>(<span></span>)</td>
		</tr>
		<tr>
			<td><span></span>(<span></span>)</td>
		</tr>
		<tr>
			<td><span></span>(<span></span>)</td>
		</tr>
	</table>
	
	<hr>
	
	<div>
		<div class="item" id="item1"><span></span><span></span></div>
		<div class="item" id="item2"><span></span><span></span></div>
		<div class="item" id="item3"><span></span><span></span></div>
		<div class="item" id="item4"><span></span><span></span></div>
	</div>
	
	<hr>
	
	<h2>또 다른 내용</h2>
	
	<div>
		<input type="text" id="txt1">
		<br><br>
		<input type="checkbox">
	</div>
	
	<hr>
	
	<!-- 원칙적으로는 서로다른 두페이지가 소통할 수 없으나 iframe으로는 가능 -->
	<iframe src="/ajax/ex02data.do" width="800" height="300" scrolling="no"></iframe>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	</script>	
</body>
</html>