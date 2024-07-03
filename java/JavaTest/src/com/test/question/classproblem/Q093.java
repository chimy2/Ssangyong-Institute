package com.test.question.classproblem;

public class Q093 {
//	클래스: Note
	public static void main(String[] args) {
//		요구사항] Note 클래스를 설계하시오.
//			- Note 객체의 정보
//				- 크기, 표지 색상, 페이지수, 소유자이름, 가격
//			- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//			- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//				- 크기 : 쓰기 전용, A3, A4, A5, B3, B4, B5
//				- 표지 색상 : 쓰기 전용, 검정색, 흰색, 노란색, 파란색
//				- 페이지수 : 쓰기 전용, 10 ~ 200페이지 이내
//				- (+) 10~50(얇다), 51 ~ 100(보통), 101 ~ 200(두껍다)
//				- 소유자이름 : 쓰기 전용, 한글 2~5자이내. 필수값
//				- 가격 : Setter,Getter 구현 안함. 추후 info() 메소드에서 사용하기 위해 아래와 같은 규칙으로 계산
//				- (+) 기본 노트 : A5 + 흰색 + 10페이지 = 가격(500원)
//				- (+) 크기 변경 : A3(+400원), A4(+200원), B3(+500원), B4(+300원), B5(+100원)
//				- (+) 색상 변경 : 검정색(+100원), 노란색(+200원), 파란색(+200원)
//				- (+) 페이지수 변경 : 페이지 당 x 10원 추가
//			- Note 객체의 정보를 확인하기 위한 메소드를 구현한다.
//				- String info()
//			- Note가 잘 설계되었는지 객체를 가지고 사용해본다.
//				- Note 객체 생성 → 값 넣기 + 값 출력 등
		
		/*
		기초코드
		class Note  {
		   private String size;
		   private String color;
		   private int page;
		   private String owner;
		   private int price;
		
		   //setter, getter 구현
		
		   public String info() {
		         return ..
		   }
		}
		
		호출
		Note note = new Note();
		
		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");
		
		System.out.println(note.info());
		
		
		Note note2 = new Note();
		
		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);
		
		System.out.println(note2.info());
		
		출력
		■■■■■■ 노트 정보 ■■■■■■
		소유자 : 홍길동
		특성 : 노란색 얇은 B4노트
		가격 : 1,150원
		■■■■■■■■■■■■■■■■■■■■■■
		
		■■■■■■ 노트 정보 ■■■■■■
		주인 없는 노트
		■■■■■■■■■■■■■■■■■■■■■■
		 */
		Note note = new Note();

		note.setSize("B4");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");

		System.out.println(note.info());


		Note note2 = new Note();

		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);

		System.out.println(note2.info());
	}
}
