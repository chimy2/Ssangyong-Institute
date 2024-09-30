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
		
	</style>
</head>
<body>
	<!-- ex08.jsp -->
	<h1>고양이 + Ajax</h1>
	
	<div><img src="images/catty01.png"></div>
	<!-- <div><img src="/ajax/WEB-INF/views/images/catty01.png"></div> -->
	<div><img src="/ajax/images/catty01.png"></div>
	<!-- 
		맞는 경로이지만 이미지가 불러와지지 않음
		> why? > 톰캣이 처음에 가져올 때 java코드가 아닌 것을 인식하지 못하기 때문에
			> 브라우저는 무슨 수를 쓰더라도 WEB-INF에 있는 모든 것을 접근하지 못한다
	 		> 이미지는 브라우저가 따로 요청하는 자원이기 때문에 WEB-INF 바깥에 파일을 두어야 한다.
	 	
	 	> views > images 폴더를 webapp로 옮겨 브라우저의 접근을 허용함
	 -->
	
	<div><img src="/ajax/images/catty01.png" id="cat1"></div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		// 고양이의 위치값 저장 공간 
		// 1. 쿠키 > 양호, 접속 위치 불편
		// 2. 세션 > 안좋음, 브라우저를 닫았다 키면 세션이 바뀌어 버림
		// 3. DB > 아주 양호
	
		$('#cat1').draggable({
			stop: function(event, ui) {
				// alert();
				
				//console.log(ui.position); > position: relative;
				
				// console.log(this.id);
				$.ajax({
					type: 'POST',
					url: '/ajax/ex08data.do',
					data: 'catid=' + this.id + '&left=' 
						+ ui.position.left + '&top=' + ui.position.top,
					error: function(a, b, c) {
						console.log(a, b, c);
					}
				});
	 		}
		});
		
		$('#cat1').css({
			left: '${dto.left}px',
			top: '${dto.top}px'
		});
	</script>	
</body>
</html>