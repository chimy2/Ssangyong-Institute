<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		#box {
			width: 128px;
			height: 128px;
			border: 1px solid #CCC;
			background-color: gold;
			margin-top: 10px;
		}
	</style>
</head>
<body>
	<!-- ex09.jsp -->
	<h1>고양이</h1>
	
	<div>
		<input type="button" value="고양이 추가하기" id="btnAdd">
		<div id="box"></div>
	</div>
	<div id="list"></div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		let n = 1;
		let seq = ${seq};
	
		$('#btnAdd').click(() => {
			// $(부모).append('자식 태그');
			// $('자식 태그').appendTo(부모);
			/*
			박스에 draggable이 적용됨 > 따라서 appendTo를 사용하는 것이 편리하다
			$('#box')
				.append('<img src="/ajax/images/catty01.png">')
				.draggable();
			 */

			/* 
				int to String
				
				1 + '' 			> '1'
				1.toString() 	> '1'
				String(1) 		> '1'
			
			*/
			
			$('<img src="/ajax/images/catty' + String(n).padStart(2, 0) + '.png" id="cat' + seq + '">')
				.draggable({
					stop: function(event, ui) {
						// $('#list').append(this);
						$.ajax({
							type: 'POST',
							url: '/ajax/ex08data.do',
							data: 'catid=cat' + seq + '&left=' + ui.position.left + '&top=' + ui.position.top,
							error: function(a, b, c) {
								console.log(a, b, c);
							}
						});
					}
					
				})
				.appendTo($('#box'));
				
			// 추가된 고양이를 서버로 전송 + DB insert
			
			$.ajax({
				type: 'POST',
				url: '/ajax/ex09data.do',
				data: 'catid=cat' + seq,
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
			n++;
			seq++;
			if(n > 21) n = 1;
		});
		
		<c:forEach var="dto" items="${list}">
			/* $('#${dto.catid}').css({
				left: '${dto.left}',
				top: '${dto.top}'
			}); */
			
			$('<img src="/ajax/images/catty01.png" id="${dto.catid}">')
				.appendTo('#box')
				.draggable({
					stop: function(event, ui) {
						$.ajax({
							type: 'POST',
							url: '/ajax/ex08data.do',
							data: 'catid=${dto.catid}&left=' + ui.position.left + '&top=' + ui.position.top,
							error: function(a, b, c) {
								console.log(a, b, c);
							}
						});
					}
				})
				.css({
					left: '${dto.left}',
					top: '${dto.top}'
				});
			n++;
			if (n > 21) n = 1;
		</c:forEach>
	</script>	
</body>
</html>