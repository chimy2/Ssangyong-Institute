package com.test.java.obj;

public class Ex28_Class {
	public static void main(String[] args) {
		/*
		 * 자바
		 * - 객체 지향 프로그래밍 언어
		 * - Object Oriented Programming Language > OOP
		 * - 객체를 중심으로 프로그램을 만드는 방식
		 * - 클래스라는 설계도를 사용해서, 
		 * 	객체라는 것을 만들고,
		 * 	만들어진 객체를 사용해서,
		 * 	내가 원하는 행동을 구현하는 것..
		 * 
		 * 
		 * 1. 클래스, Class 
		 * - 객체를 만드는 설계도
		 * - 객체를 분류하는 기준
		 * - 자료형
		 * - 붕어빵틀
		 * 
		 * 2. 객체, Object
		 * - 붕어빵
		 * 
		 * 3. 인스턴스, Instance
		 * - 붕어빵
		 * - 메모리에 실체화된 객체, 메모리에 진짜 생성된 객체
		 * 
		 * 4. 추상화
		 * 
		 * 5. 정보은닉
		 * 
		 * 6. 캡슐화
		 * 
		 * 7. 상속
		 * 
		 * 8. 다형성
		 * 
		 * 9. 인터페이스
		 * 
		 * 10. 프로퍼티(Property), 속성(Attribute)
		 * 
		 * 11. 행동(Behavior)
		 */
		
//		요구사항] 지도 > 우리집 > 좌표 저장
		
//		Case 1.
//		- 가장 간단한 방법
//		- 식별자 문제 > 같은 성질의 식별자가 서로 다른 이름을 사용
//		- 구조적 문제 > 규칙(X), 쌍 보장(X)
		
//		우리집 좌표
		int x = 100;
		int y = 200;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", x, y);
		
//		마트 좌표
		int x2 = 300;
		int y2 = 400;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", x2, y2);
		
//		Case 2.
//		- 배열 사용
//		- 데이터 저장 구조 > 집합 > 관리 용이 + 가독성
//		- 배열 단점 > 요소를 구분할 단서 > 방번호 > 의미를 부여할 수 없다
		
//		🌟🌟🌟 배열은 같은 성질의 같은 자료형의 집합
		
//		우리집 좌표
//		- 정수 2개
		int[] a1 = { 100, 200 };
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", a1[0], a1[1]);
		
//		마트 좌표
		int[] a2 = { 300, 400 };
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", a2[0], a2[1]);
		
//		Case 3.
//		- 클래스 사용
//		- 데이터 집합을 역할
//		- 데이터 저장 구조 역할(x, y)
//		- 각 멤버의 이름을 정의 가능(x, y) > 멤버의 성질 구분
//		- 초기 비용 발생!!
		
//		선언된 클래스로 > 객체를 생성하는 방법
//		- 자료형 변수명 = new 생성자();
//		- 클래스(자료형) 객체(변수)명 = 객체생성연산자 생성자();
		
//		우리집 좌표
//		Point 클래스의 p1라는 인스턴스를 생성했습니다.
//		p1 객체를 생성했습니다.
//		p1은 실제 객체(heap에 위치)가 아니라 실제 객체를 저장한 주소값(stack에 위치)을 저장한 변수지만
//		p1을 부르는 것은 실제 메모리에 있는 이름 없는 객체를 부르는 것과 똑같기 때문에
//		p1 객체라고 부른다
		Point p1 = new Point();	//붕어빵틀 > 붕어빵 1개 생성
		
		p1.x = 100;
		p1.y = 200;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", p1.x, p1.y);
		
//		마트 좌표
		Point p2 = new Point();
		
//		멤버 접근 연산자
		p2.x = 300;
		p2.y = 400;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", p2.x, p2.y);
		
		System.out.println();
		
		
		Size monitor = new Size();
		
		monitor.name = "LG 모니터";
		monitor.width = 1920;
		monitor.height = 1080;
		
		System.out.println(monitor.name + ":" + monitor.width +"," + monitor.height);
		
		Score s1 = new Score();
		
		s1.name = "홍길동";
		s1.kor = 100;
		s1.eng = 90;
		s1.math = 80;
		
//		클래스를 왜 자료형이라고 하는가?
//		> 초기화 하지 않아도 어떤 값이 들어갈지 예측이 가능하기 때문이다.
		int a = 10;
		boolean b = true;
		
		Point point;
		Score score;
	}
}

//클래스 선언하기(= 붕어빵 틀 만들기)
//- 클래스명 : 파스칼 표기법
class Point {
//	구현부
//	- 클래스의 멤버를 선언하기
//	1. 변수
//	2. 메서드
	
//	멤버 변수
	public int x;
	public int y;
}

class Size {
	public String name;
	public int width;
	public int height;
}

class Score {
	
	public String name;
	public int kor;
	public int eng;
	public int math;
}