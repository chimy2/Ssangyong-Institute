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
		#list th:nth-child(1) { width: 50px; }
		#list th:nth-child(2) { width: 70px; }
		#list th:nth-child(3) { width: 60px; }
		#list th:nth-child(4) { width: 60px; }
		#list th:nth-child(5) { width: 140px; }
		#list th:nth-child(6) { width: auto; }
		
		#list td { text-align: center; }
		#list td:nth-child(6) { text-align: left; }
		#list td:nth-child(6) > span:nth-child(2),
		#list td:nth-child(6) > span:nth-child(3) {
			float: right; 
			cursor: pointer; 
		}
		
		#btnCancel {
			display: none;
		}
	</style>
</head>
<body>
	<!-- ex10.jsp -->
	<!-- 
		Rendering
		1. SSR, Server Side Rendering
		2. CSR, Client Side Rendering
			- 모바일용 페이지
			- 자바스크립트 프레임워크(Angular, React, Vue)
			- Ajax 관련 처리 페이지
	 -->
	 
	 <h1>주소록 <small>Ajax + CSR</small></h1>
	 
	 <table id="list">
	 	<thead>
			<tr>
		 		<th>번호</th>
		 		<th>이름</th>
		 		<th>나이</th>
		 		<th>성별</th>
		 		<th>전화</th>
		 		<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<!-- 		 	
			<tr>
		 		<td></td>
		 		<td></td>
		 		<td></td>
		 		<td></td>
		 		<td></td>
		 		<td></td>
			</tr>
			-->
		</tbody>
	 </table>
	 
	 <hr>
	 
	 <form id="form1">
	 	<div>
	 		<label>이름: </label>
	 		<input type="text" name="name" id="name">
	 	</div>
	 	<div>
	 		<label>나이: </label>
	 		<input type="text" name="age" id="age">
	 	</div>
	 	<div>
	 		<label>성별: </label>
	 		<select name="gender" id="gender">
	 			<option value="m">남자</option>
	 			<option value="f">여자</option>
	 		</select>
	 	</div>
	 	<div>
	 		<label>전화: </label>
	 		<input type="text" name="tel" id="tel">
	 	</div>
	 	<div>
	 		<label>주소: </label>
	 		<input type="text" name="address" id="address">
	 	</div>
	 	<div>
	 		<input type="button" value="추가하기" id="btnSend">
	 		<input type="button" value="취소하기" id="btnCancel">
	 	</div>
	 	<input type="hidden" name="seq" id="seq">
	 </form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		// 서버 > (데이터) > ajax
		// 1. Text
		// 2. XML
		// 3. JSON
		
		// ajax > (데이터) > 서버
		// 1. QueryString
		// 2. 직렬화(객체를 일련의 한줄 문자열로 만드는 작업)
		// 3. 객체 > jQuery 기능
		
		$('#btnSend').click(() => {
			// name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=20&gender=m&address=%EC%84%9C%EC%9A%B8%EC%8B%9C
			// console.log($('#form1').serialize());
			// 직렬화 메소드를 이용하고 싶으면 태그에 반드시 name이 있어야 한다.
			// name 속성을 가지지 않는 태그는 가져오지 않음
			
			// if(버튼역할) {
			if ($(event.target).val() == '추가하기') {
				// 추가하기
				addok();
			} else {
				// 수정하기
				editok();
			}
		});
		
		function load() {
			$.ajax({
				type: 'GET',
				url: '/ajax/ex10data.do',
				dataType: 'json',
				success: function(result) {
					if(result.result == 1) {
						// 목록 가져오기 성공
						
						$('#list tbody').html('');
						
						result.arr.forEach(item => {
							$('#list tbody').append(`
									<tr>
										<td>\${item.seq}</td>
										<td>\${item.name}</td>
										<td>\${item.age}</td>
										<td>\${item.gender == 'm' ? '남자' : '여자'}</td>
										<td>\${item.tel}</td>
										<td>
											<span>\${item.address}</span>
											<span class="material-symbols-outlined"
												onclick="del(\${item.seq});">
											delete
											</span>
											<span class="material-symbols-outlined"
												onclick="edit();">
											edit_note
											</span>
										</td>
									</tr>							
									`);					
						});
						
					} else {
						// 실패
					}
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		}
		
		load();
		
		function del(seq) {
			
			if(!confirm('delete')) {
				return;
			}
			
			$.ajax({
				type: 'POST',
				url: '/ajax/ex10del.do',
				data: 'seq=' + seq,
				dataType: 'json',
				success: function(result) {
					if(result.result == 1) {
						load();
					} else {
						alert("삭제 실패");
					}
				},
				error: function(a, b, c) {
					console.log(a, b, c);					
				}
			});
		}
		
		function edit() {
			// alert($(event.target).parent().children().first().text());
			
			const tel = $(event.target).parent().prev().text();
			const gender = $(event.target).parent().prev().prev().text();
			const age = $(event.target).parent().prev().prev().prev().text();
			const name = $(event.target).parent().prev().prev().prev().prev().text();
			const seq = $(event.target).parent().prev().prev().prev().prev().prev().text();
			const address = $(event.target).parent().children().first().text();
			
			$('#name').val(name);
			$('#age').val(age);
			$('#gender').val(gender == '남자' ? 'm' : 'f');
			$('#tel').val(tel);
			$('#address').val(address);
			$('#seq').val(seq);
			
			$('#btnSend').val('수정하기');
			$('#btnCancel').show();
		}
		
		$('#btnCancel').click(() => {

			$('#seq').val('')
			$('#name').val('');
			$('#age').val('');
			$('#gender').val('m');
			$('#tel').val('');
			$('#address').val('');
			
			$('#btnSend').val('추가하기');
			$('#btnCancel').hide();
		})
		
		function addok() {

			$.ajax({
				type: 'POST',
				url: '/ajax/ex10add.do',
				// 1.
				/* 
				data: 'name=' + $('#name').val() + '&age=' + $('#age').val() + '&gender=' 
					+ $('#gender').val() + '&tel=' + $('#tel').val()+ '&address=' + $('#address').val(), */
				// 2.
				/* 
				data: $('#form1').serialize(),*/				
				// 3.
				data: {
					name: $('#name').val(),
					age: $('#age').val(),
					gender: $('#gender').val(),
					tel: $('#tel').val(),
					address: $('#address').val()
				},
				dataType: 'json',
				success: function(result) {
					if(result.result) {
						$('#name').val('');
						$('#age').val('');
						$('#gender').val('m');
						$('#tel').val('');
						$('#address').val('');
						
						load();
					} else {
						alert('추가 실패');
					}
				},
 				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		}
		
		function editok() {
			$.ajax({
				type: 'POST',
				url: '/ajax/ex10edit.do',
				data: {
					seq: $('#seq').val(),
					name: $('#name').val(),
					age: $('#age').val(),
					gender: $('#gender').val(),
					tel: $('#tel').val(),
					address: $('#address').val()
				},
				dataType: 'json',
				success: function(result) {
					if(result.result) {
						$('#name').val('');
						$('#age').val('');
						$('#gender').val('m');
						$('#tel').val('');
						$('#address').val('');
						
						load();
						$('#btnSend').val('추가하기');
					} else {
						alert("수정 실패");
					}
				},
				error: function(a, b, c) {
					console.log(a, b, c);					
				}
			});	
		}
	</script>	
</body>
</html>