package com.test.question.classproblem;

public class Q096 {
//	클래스: Box
	public static void main(String[] args) {
//		요구사항] Box 클래스와 Macaron 클래스를 설계하시오.
//			- Box 객체의 정보
//				- 1Box에는 10개의 마카롱을 담을 수 있다.(멤버 변수 = Macaron 배열)
//				- Box 객체의 사용
//				- Box 객체를 생성시 Box에 마카롱 객체를 10개 담는다.(무작위)
//				- 품질 검사에 통과하지 못하는 마카롱을 구분한다.
//			- Macaron 객체의 정보
//				- 생산 크기(5cm ~ 15cm) → 판매 유효 크기(8cm ~ 14cm)
//				- 생산 색상(red, blue, yellow, white, pink, purple, green, black) → 판매 유효 색상(black을 제외한 모든 색상)
//				- 생산 샌드 두께(1mm ~ 20mm) → 판매 유효 두께(3mm ~ 18mm)
		/*
		기초코드-----------------------------------------------------------
		class Box {
		   private Maron[] list = new Maron[10];

		   public void cook() {
		   }
		   public void check() {
		   }
		   public void list() {
		   }
		}

		class Macaron {
		   private int size;
		   private String color;
		   private int thickness;
		}
		
		호출-----------------------------------------------------------
		Box box1 = new Box();

		box1.cook();
		box1.check();
		box1.list();
		
		출력-----------------------------------------------------------
		마카롱을 10개 만들었습니다. //box1.cook();

		[박스 체크 결과] //box1.check();
		QC 합격 개수 : 8개
		QC 불합격 개수 : 2개

		[마카롱 목록] //box1.list();
		1번 마카롱 : 10cm(red, 5mm) : 합격
		2번 마카롱 : 12cm(blue, 12mm) : 합격
		..
		9번 마카롱 : 13cm(yellow, 2mm) : 불합격
		10번 마카롱 : 10cm(black, 6mm) : 불합격
		*/
		
		Box box1 = new Box();

		box1.cook();
		box1.check();
		box1.list();
	}
}
