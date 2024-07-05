package com.lesson.java;

import java.util.Scanner;

public class Ex15_Method {
	
	public static void main(String[] args) {
		
		//Ex15_Method.java
		
		//public static void hello()
		
		//void: 반환타입
		// - void == 없다. == null
		
		String name = getName();
		System.out.println(name);
		
		String result = checkScore(100, 90, 80);
		System.out.println(result);
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		
	}//main
	
	//This method must return a result of type String
	//This method must return a result of type int
	
	//String > 반환타입
	public static String getName() {
		
		//return문
		return "홍길동"; //메서드 종료 + 돌아가기
		
		//System.out.println("종료");
	}
	
	public static String checkScore(int kor, int eng, int math) {
		
		int total = kor + eng + math;
		
		double avg = total / 3.0;
		
		String result = avg >= 60 ? "합격" : "불합격";
		
		return result;		
	}

}













