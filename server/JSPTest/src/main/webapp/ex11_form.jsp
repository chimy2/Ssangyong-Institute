<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<script src="https://kit.fontawesome.com/dd69cb37e8.js" crossorigin="anonymous"></script>
	<style>
		#width, #height, #txt {
			width: 100px;
		}
		
		#fontsize {
			width: 50px;
		}
	</style>
</head>
<body>
	<!-- ex11_form.jsp -->
	<h1>버튼 만들기</h1>
	
	<form action="ex11_ok.jsp" method="POST">
		<table class="vertical">
			<tr>
				<th>너비(px)</th>
				<td><input type="number" name="width" id="width" value="120" min="20" max="300"></td>
			</tr>
			<tr>
				<th>높이(px)</th>
				<td><input type="number" name="height" id="height" value="30" min="10" max="200"></td>
			</tr>
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" id="txt" value="Button"></td>
			</tr>
			<tr>
				<th>배경색</th>
				<td><input type="color" name="bgcolor" id="bgcolor" value="#fff"></td>
			</tr>
			<tr>
				<th>글자색</th>
				<td><input type="color" name="fontcolor" id="fontcolor" value="#000"></td>
			</tr>
			<tr>
				<th>글자 크기(px)</th>
				<td><input type="number" name="fontsize" id="fontsize" value="16"></td>
			</tr>
			<tr>
				<th>버튼 개수(ea)</th>
				<td><input type="number" name="btncount" id="btncount" value="1" min="1" max="30"></td>
			</tr>
			<tr>
				<th>버튼 간격</th>
				<td>
					좌우 간격: <input type="range" value="0" min="0" max="50" name="horizontalspacing"><br>
					상하 간격: <input type="range" value="0" min="0" max="50" name="verticalspacing">
				</td>
			</tr>
			<tr>
				<th>아이콘</th>
				<td>
					<input type="radio" name="icon" value="none"> 없음
					<input type="radio" name="icon" value="house"> <i class="fa-solid fa-house"></i>
					<input type="radio" name="icon" value="image"> <i class="fa-solid fa-image"></i>
					<input type="radio" name="icon" value="map"> <i class="fa-solid fa-location-dot"></i>
					<input type="radio" name="icon" value="git"> <i class="fa-brands fa-github"></i>
					<input type="radio" name="icon" value="clip"> <i class="fa-solid fa-paperclip"></i>
					
				</td>
			</tr>
			<tr>
				<th>테두리</th>
				<td>
					<select class="border" name="border">
						<option value="hide">감추기</option>
						<option value="show">보이기</option>
					</select>
					<div>
						두께(px): <input type="number" value="1" name="bordersize"><br>
						색상: <input type="color" value="#000"><br>
						스타일: <select class="borderstyle" name="borderstyle">
							<option>실선</option>
							<option>쇄선</option>
							<option>점선</option>
						</select><br>
						모서리(px): <input type="number" value="0" min="0" max="50" name="borderradius">
					</div>
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="만들기">
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>	
</body>
</html>