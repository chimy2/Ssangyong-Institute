package com.test.question.classproblem;

public class Q094 {
//	클래스: Bugles
	public static void main(String[] args) {
//		요구사항] 과자(Bugles) 클래스를 설계하시오.
//			- Bugles 객체의 정보
//				- 가격, 용량, 생산일자, 유통기한
//				- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//				- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//					- 용량 : 쓰기 전용, 300g, 500g, 850g
//					- 가격 : 읽기 전용, 850원(300g), 1200원(500g), 1950원(850g)
//					- 생산일자 : 쓰기 전용(Calendar)
//					- 남은유통기한 : 읽기 전용, 생산된 제품의 유통기한 기준 : 7일(300g), 10일(500g), 15일(850g)
//				- Bugles 객체 메소드
//					- void eat() : 과자 먹기
//				- 먹을수 있는 날짜 = 유통기한 - 현재 - 제조시간
//					- 5 : 먹을 수 있는 날짜가 5일 남음
//					- -3 : 먹을 수 있는 날짜가 3일 지남
		
		/*
		기초코드-----------------------------------------------------------
		class Bugles {
		   private int price;
		   private int weight;
		   private Calendar creationTime;
		   private int expiration;
		
		   //getter, setter 구현
		
		   public void eat() {
		
		   }
		}
		
		호출-----------------------------------------------------------
		Bugles snack = new Bugles();
		
		snack.setSize(500);
		snack.setCreationTime("2024-06-29");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");
		
		snack.eat();
		
		
		Bugles snack2 = new Bugles();
		
		snack2.setSize(300);
		snack2.setCreationTime("2024-06-21");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");
		
		snack2.eat();
		
		출력-----------------------------------------------------------
		가격 : 1,200원
		유통기한 : 5일 남았습니다.
		과자를 맛있게 먹습니다.
		
		가격 : 850원
		유통 기한이 -6일 남았습니다.
		유통기한이 지나 먹을 수 없습니다.
		 */

		Bugles snack = new Bugles();
		
		snack.setSize(500);
		snack.setCreationTime("2024-06-29");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");
		
		snack.eat();
		
		
		Bugles snack2 = new Bugles();
		
		snack2.setSize(300);
		snack2.setCreationTime("2024-06-21");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");
		
		snack2.eat();
	}
}
