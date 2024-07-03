package com.test.question.classproblem;

public class Q092 {
//	클래스: Book
	public static void main(String[] args) {
//		요구사항] Book 클래스를 설계하시오.
//			- Book 객체의 정보
//				- 제목, 가격, 저자, 출판사, 발행년도, ISBN, 페이지수
//			- 모든 멤버 변수의 접근 지정자는 private으로 한다.
//			- 멤버 접근을 위한 Setter와 Getter를 정의한다.
//				- 제목 : 읽기/쓰기, 최대 50자 이내(한글, 영어, 숫자, 공백)
//				- 가격 : 읽기/쓰기, 0 ~ 1000000원
//				- 저자 : 읽기/쓰기, 제한 없음
//				- 페이지수 : 읽기/쓰기, 1~무제한
//				- 출판사 : 쓰기 전용
//				- 발행년도 : 읽기 전용(2019년)
//				- ISBN : 읽기/쓰기
//			- Book 객체의 모든 정보를 문자열로 반환하는 메소드를 구현한다.
//				- String info()
//			- 클래스가 잘 설계되었는지 객체를 가지고 사용해본다.
//				- Book 객체 생성
//				- 멤버 값 넣기 + 값 출력
//				- 유효성 검사 테스트
		/*
		기초코드
		class Book {
		   private String title;
		   private int price;
		   private String author;
		   private String publisher;
		   private String pubYear = "2019";
		   private String isbn;
		   private int page;

		   //getter, setter

		   public String info() {
		         return ..
		   }
		}
		호출
		Book b1 = new Book();
		
		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);
		
		System.out.println(b1.info());
		
		출력
		제목: 자바의 정석
		가격: 45,000원
		저자: 남궁성
		출판사: 도우출판
		발행년도: 2019년
		ISBN: 8994492038         
		페이지: 1,022장
		*/
		Book b1 = new Book();

		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);
		
		System.out.println(b1.info());
	}
}
