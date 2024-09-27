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
	<!-- ex03.jsp -->
	<h1>Ajax</h1>
	
	<!-- 
		1. 버튼을 클릭
		2. 서버에게 데이터를 주세요~ 요청
		3. 응답된 데이터를 화면에 출력
	
	 -->
	 
	 <form action="/ajax/ex03data.do">
	 	<!-- <div><a href="/ajax/data.txt">가져오기</a></div> -->
	 	<!-- <div><a href="/ajax/ex03data.do">가져오기</a></div> -->
	 	<div><input type="submit" value="가져오기"></div>
	 	<div><input type="button" value="가져오기" id="btn1"></div>
	 	<hr>
	 	<div class="message">${data}</div>
	 </form>
	
	<hr>
	
	<div>
		다른 업무: <input type="text">
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		$('#btn1').click(() => {
			
			// 서버와 통신할 수 있는 자바스크립트 객체
			const ajax = new XMLHttpRequest();	// ajax 객체
			
			
			// alert(ajax.readyState);	// 0
			
			// on + readystate change
			// readyState: ajax 객체의 상태를 표현하는 값
			// 0 ~ 4
			/* 
				 1. UNSENT (숫자 0) : XMLHttpRequest 객체가 생성됨.
				 2. OPENED (숫자 1) : open() 메소드가 성공적으로 실행됨.
				 3. HEADERS_RECEIVED (숫자 2) : 모든 요청에 대한 응답이 도착함.
				 4. LOADING (숫자 3) : 요청한 데이터를 처리 중임.
				 5. DONE (숫자 4) : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
			*/
			ajax.onreadystatechange = function() {
				// console.log(111);
				// el과 충돌나서 있는 값이지만 빈값이 출력됨
				// $('.message').append(`<div>${ajax.readyState}</div>`);
				/* 
					1
					2
					3
					4
				*/
				// 일부러 / by zero 에러를 낸 상황
				// $('.message').append(`<div>\${ajax.status}</div>`);
				// return;
				/* 
					0
					500
					500
					500
				*/
				
				// 응답이 돌아오고 서버에 에러가 없을 때
				if (ajax.readyState == 4 && ajax.status != 500) {
					// 서버에 요청한 응답이 돌아오는 시점!!
					
					// 서버가 ajax 객체에게 돌려준 데이터 
					$('.message').text(ajax.responseText);
				}
			}
			
			// <form method="GET" action="/ajax/data.txt">
			// ajax.open('GET', '/ajax/ex03data.do');	// 연결(X), 설정(O)
			ajax.open('GET', '/ajax/ex03data.do');
			
			// <input type="submit"> 클릭			
			ajax.send();	// 실제로 ajax 객체가 서버에 연결
			// 시간이 지연될 수 있으므로 함수 형식이 아닌 이벤트 형식으로 응답을 주고 받음
			//	> 비동기 방식으로 해야 기다리지 않고 나중에 응답이 올 때 실행함
		});
	</script>	
</body>
</html>