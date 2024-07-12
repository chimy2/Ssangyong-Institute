package com.test.java.obj;

import com.lesson.java.resource.Test;
import com.lesson.java.resource.회원;

public class Ex35_Static {
//	1. 여러가지 선행 작업 > 클래스 로딩(클래스 인식)
//	- 클래스 로딩을 위해 클래스들을 읽는 과정 중 정적 멤버들은 메모리에 올려놓음
//	- 메소드 영역 중 클래스 이름의 영역에 해당 클래스의 정적 필드/메소드 공간 생성
//	2. main > 프로그램 시작점 
	public static void main(String[] args) {
		/*
		 * static 키워드
		 * - 지시자 중 하나
		 * - 클래스 or 클래스 멤버에 붙이는 키워드
		 */
		
//		상황] 학생 3명 
//		- "역삼 중학교"
		
		Student.setSchool("역삼중학교");
//		다른 객체와 관련된 것이 아니라 따로 관리
		
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(15);
//		s1.setSchool("역삼중학교");
//		The static method setSchool(String) from the type Student should be accessed in a static way
//		Student.setSchool("역삼중학교");
		
		Student s2 = new Student();
		s2.setName("강아지");
		s2.setAge(14);
//		s2.setSchool("역삼중학교");
//		Student.setSchool("역삼중학교");
		
		Student s3 = new Student();
		s3.setName("고양이");
		s3.setAge(16);
//		s3.setSchool("역삼중학교");
		
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(s3.info());
		
		Test t1 = new Test();
		
		회원 길동 = new 회원();
		회원 강아지 = new 회원();
		회원 고양이 = new 회원();
		
		길동.회원명수정하기("길철");	//개인적인 > 객체 변수, 객체 메서드
	//	길동.모임명수정하기("스터디");
		
		회원.모임명수정하기("스터디");	//단체 > 정적 변수, 정적 메서드
	}
}

class Student {
	private String name;
	private int age;
	
//	private String school;
	private static String school;
//	static private String school;도 가능
	
//	static을 잘 사용하지 않은 이유
//	1. 생명주기가 너무 길다.
//	2. 관리가 너무 힘들다.

	public String getName() {
		return name;
	}

	public void setName(String name) {
//		this - 객체가 자신을 가리키는 말
//		객체 - new로 만든 것
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
//		return String.format("%s(%d세, %s)", this.name, this.age, this.school);
//		The static field Student.school should be accessed in a static way
		return String.format("%s(%d세, %s)", this.name, this.age, Student.school);
	}

	public static String getSchool() {
		return school;
	}

	public static void setSchool(String school) {
//		Cannot use this in a static context
//		정적 멤버는 객체가 아니기 때문에 this를 쓸 수 없다.
		Student.school = school;
	}
}

class Test {
	private int a;
	private static int b;
	
//	객체 메서드 > 객체 변수, 객체 메서드, 정적 변수, 정적 메서드 접근 가능
//	정적(static) 메서드 > 정적 변수, 정적 메서드만 접근 가능
	
	public void ccc() {
//		객체 메서드 > 객체 변수, 정적 변수
		a = 10;
		b = 20;
		
		this.a = 30;
		Test.b = 40;
		
		ddd();
	}
	
	
	public static void ddd() {
//		정적 메서드 > 객체 변수, 정적 변수
		a = 30;	//Cannot make a static reference to the non-static field a
		this.a = 30;	//Cannot use this in a static context
//		a가 문제가 아니라 this 문제, this는 객체라는 인스턴스가 자신을 부를 때 쓰는 키워드
		
		ccc();	//Cannot make a static reference to the non-static method ccc() from the type Test
		this.ccc();	//Cannot use this in a static context
		b = 40;
		
		Test test = new Test();
		int d=test.a;
		test.ccc();
	}
}

class 회원 {
	private String 회원명;	//객체 변수 > 개인 정보
	private static String 모임명;	//정적 변수 > 공용 정보
	
	public void 회원명수정하기(String 이름) {
		this.회원명 = 이름;
	}
	
	public static void 모임명수정하기(String 이름) {
		회원.모임명 = 이름;
	}
}
