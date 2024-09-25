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
	<!-- webapp > list.jsp -->
	<h1>상품 목록</h1>
	
	<div id="list">
		<!-- <div class="item">
			<div>마우스</div>
			<div>흰색</div>
		</div>
		<div class="item">
			<div>키보드</div>
			<div>갈색</div>
		</div>
		<div class="item">
			<div>스마트폰</div>
			<div>핑크색</div>
		</div> -->
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		const list = [
			{
				name: '마우스',
				color: '흰색'
			},
			{
				name: '키보드',
				color: '갈색'
			},
			{
				name: '스마트폰',
				color: '핑크색'
			}
		];
		
		$(list).each((index, item) => {
			$('#list').append('<div class="item"><div>' + item.name 
					+ '</div><div>' + item.color + '</div></div>');
		})
	</script>	
</body>
</html>