package com.lesson.java.obj;

public class Ex35_Static {
	
	//1. 여러가지 선행 작업 > 클래스 로딩(클래스 인식)
	//2. main > 프로그램 시작
	public static void main(String[] args) {
		
		//Ex35_Static.java
		/*
		
			static(정적) 키워드
			- 지시자 중 하나
			- 클래스 or 클래스 멤버에 붙이는 키워드
					
		*/
		
		//상황] 학생 3명
		//- "역삼 중학교"
		
		Student.setSchool("역삼중학교");
		
		
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(15);
		//s1.setSchool("역삼중학교");
				
		Student s2 = new Student();
		s2.setName("강아지");
		s2.setAge(14);
		//s2.setSchool("역삼중학교");
		//Student.setSchool("역삼중학교");
		
		Student s3 = new Student();
		s3.setName("고양이");
		s3.setAge(16);
		//s3.setSchool("역삼중학교");
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
			
		
		Test t1 = new Test();
		
		
		회원 길동 = new 회원();
		회원 강아지 = new 회원();
		회원 고양이 = new 회원();
		
		길동.회원명수정하기("길철"); //개인적인 > 객체 변수, 객체 메서드
		//길동.모임명수정하기("스터디");
		
		회원.모임명수정하기("스터디"); //단체 > 정적 변수, 정적 메서드
		
		
	}//main
	
}//class


class 회원 {
	
	private String 회원명; //객체 변수 > 개인 정보
	private static String 모임명; //정적 변수 > 공용 정보
	
	public void 회원명수정하기(String 이름) {
		this.회원명 = 이름;
	}
	
	public static void 모임명수정하기(String 이름) {
		모임명 = 이름;
	}
	
}


class Test {
	
	private int a;
	private static int b;
	
	//객체 메서드 > 객체 변수, 객체 메서드, 정적 변수, 정적 메서드
	//정적 메서드 > 정적 변수, 정적 메서드
	
	public void ccc() {
		//객체 메서드 > 객체 변수, 정적 변수
		this.a = 10;
		Test.b = 20;
		Test.ddd();
	}
	
	public static void ddd() {
		//정적 메서드 > 객체 변수, 정적 변수
		//this.a = 30;
		Test.b = 40;
		//this.ccc();
		
//		Test t2 = new Test();
//		t2.a = 30;
//		t2.ccc();
		
	}
	
}


class Student {
	
	private String name;
	private int age;
	
	//private String school;
	
	private static String school;

	public static String getSchool() {
		return school;
	}

	public static void setSchool(String school) {
		Student.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public String getSchool() {
//		return school;
//	}
//
//	public void setSchool(String school) {
//		this.school = school;
//	}
	
	public String info() {
		
		return String.format("%s(%d세,%s)"
								, this.name
								, this.age
								, Student.school);
	}
	
}













