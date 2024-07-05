package com.lesson.java;

public class Ex17_Method {
	
	public static void main(String[] args) {
		
		//Ex17_Method.java
		/*
		
			메서드 오버로딩, Method Overloading
			- 같은 이름의 메서드를 여러개 만드는 기술
			- 메서드의 인자 리스트를 다양한 형태로 구성해서, 같은 이름의 메서드를 여러개 만드는 기술
			
			메서드 오버로딩하는 이유?
			- 성능 향상(X)
			- 개발자에게 도움(O)
			

			메서드 오버로딩 구현 조건 가능
			1. 매개변수의 개수
			2. 매개변수의 자료형
			
			메서드 오버로딩 구현 조건 불가능
			1. 매개변수의 이름
			2. 반환값의 자료형
			
			
			메서드를 만드는 중..
			1. public static void test() {}				//O
			2. public static void test() {}				//X, 1번
			3. public static void test(int n) {}		//O
			4. public static void test(int m) {}		//X, 3번
			5. public static void test(String s) {}		//O
			6. public static void test(int n, int m) {}	//O
			7. public static int test() {}				//X, 1번
			
			
			메서드 호출하기(오버로딩 가능 유무 검증!!!)
			test(); //1
			test(10); //3
			test("홍길동"); //5
			test(10, 20); //6
			int num = test();
		
		*/
		
		//요구사항] 선을 그리는 메서드를 구현하시오.
		//요구사항] ----------
		//요구사항] **********
		
		drawLine();
		drawLine("$");
		
		
		System.out.println(100);
		System.out.println("문자열");
		System.out.println(true);
		System.out.println(3.14);
		
		
	}//main
	
	public static void println(int num) {
		
	}
	
	public static void println(String txt) {
		
	}
	
		
	public static void drawLine() {
		
		System.out.println("==========");
	}
	
//	public static void drawLine() {
//		
//		System.out.println("----------");
//	}
//	
//	public static void drawLine() {
//		
//		System.out.println("**********");
//	}
	
	public static void drawLine(String c) {
		
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.print(c);
		System.out.println();
	}

}


















