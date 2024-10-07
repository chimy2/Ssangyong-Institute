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
		#map {
			width: 770px;
			height: 400px;
		}
	</style>
</head>
<body>
	<!-- ex01.jsp -->
	<h1>Kakao Map <small>좌표를 통해서 주소를 얻기</small></h1>
	
	<div>
		<div id="map"></div>
	</div>
	
	<hr>
	
	<div>
		<div class="message"></div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script type="text/javascript" 
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78ff06ff1ec8759d1aff53a89d95e655&libraries=services"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.499342, 127.033198), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
			// 적을 수록 확대가 됨
		};
	
		// 지도 생성 및 객체 리턴
		// new kakao.maps.Map(container, options); 
		var map = new kakao.maps.Map(container, options); 
		
		let m1 = null;
		
		kakao.maps.event.addListener(map, 'click', function(evt) {
			if(m1 != null) {
				m1.setMap(null);
			}
			
			const path = '/api/images/default.png';
			const size = new kakao.maps.Size(64, 64);
			const op = {
					offset: new kakao.maps.Point(32, 64)
			};
			const mImg = new kakao.maps.MarkerImage(path, size, op);
			
			m1 = new kakao.maps.Marker({
				position: evt.latLng
			});
			
			m1.setImage(mImg);
			m1.setMap(map);
			
			// 클릭된 좌표 > 주소 검색
			const geocoder = new kakao.maps.services.Geocoder();
			
			// geocoder.coord2Address(경도, 위도, 콜백함수);
			geocoder.coord2Address(evt.latLng.getLng(),
					evt.latLng.getLat(),
					function(result, status) {
				// alert();
				
				if (status == kakao.maps.services.Status.OK) {
					console.log(result[0]);
					$('.message').html('지번주소: ' + result[0].address.address_name
								+ '<br>도로명 주소: ' + (result[0].road_address != null ? result[0].road_address.address_name : '없음')
							);
					/*
					$('.message').html('');
					$('.message').append('<div>지번: ' + result[0].address.address_name + '</div>');
					$('.message').append('<div>도로명: ' + result[0].road_address.address_name + '</div>');
					*/
				} else {
					alert('해당 위치의 주소를 찾지 못했습니다.');
				}
			});
		});
		
	</script>	
</body>
</html>