package ch06.sec06.exam02;

public class CarExample {
	public static void main(String[] args) {
//		Car 객체 생성
		Car myCar = new Car();
		
//		Car 객체의 필드 값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
//		Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("수정된 속도: " + myCar.speed);
		/*
		제작회사: 현대자동차
		모델명: 그랜저
		색깔: 검정
		최고속도: 350
		현재속도: 0
		수정된 속도: 60
		*/
	}
}
