package com.test.java.obj.inheritance;

import java.util.Scanner;

public class Ex46_Object {
	public static void main(String[] args) {
		/*
		 * Object 클래스
		 * - 모든 클래스의 부모 클래스이다.
		 * 
		 */
		
		AAA a1 = new AAA();
		AAA a2 = new BBB();	//부모 변수 = 자식 객체 > 업캐스팅
		AAA a3 = new CCC();	//할아버지 = 손자 객체 > 업캐스팅
		
		a3.a = 10;
		
//		Object 참조 변수는 만능 타입이다. > 모든 것을 저장할 수 있다.
		Object o1 = new Object();
		Object o2 = new AAA();
		Object o3 = new BBB();
		Object o4 = new CCC();
		
		Object o5 = new Scanner(System.in);
		Object o6 = new Test();
		
		Object o7 = new int[3];
		Object o8 = "홍길동";
		
//		이상함 > 100(int), true(boolean) > 클래스? X, 클래스 아니고 값형
		Object o9 = 100;	//Boxing 발생
//		> 원래는 오류이나 변환 >
//		Object o9 = new Integer(100);
//		값형의 데이터를 Object 변수에 넣을 때 > 박싱 발생 > 문제없이 해결할 수 있도록 해줌
//		Object 변수에 값형 데이터를 넣을 때 성능이 저하됨
		
		System.out.println(o9);	//100
//		System.out.println(o9 + 100);	
//		The operator + is undefined for the argument type(s) Object, int
//		정상적으로 출력되나 연산이 되지않음
		System.out.println((int)o9 + 100);		//언박싱 발생
		System.out.println((Integer)o9 + 100);	//언박싱 발생(FM)	
		
		Object o10 = true;
//		Object 변수에는 주소값을 넣어야 되는데 값을 넣고 있음
		
//		System.out.println(o10 ? "O" : "X");
		System.out.println((boolean)o10 ? "O" : "X");
		
		int a = 100;
		Integer b = new Integer(100);
		
		System.out.println(a == b);	//true
//		왜 값과 주소값을 비교하는데 true가 나오는가? 
//		자바는 기본적으로 값형과 참조형을 연산하려고하면 에러가 남
//		Wrapper Class는 값형처럼 쓰일 수 있는 혜택을 누림
		System.out.println(a + b);	//200
		
//		모든 자료형의 데이터 저장 가능
		Object[] list = new Object[5];
		
		list[0] = 100;
		list[1] = "홍길동";
		list[2] = true;
		list[3] = new AAA();
		list[4] = new Scanner(System.in);
		
		System.out.println("================================");
		for(int i=0; i<list.length; i++) {
			if(list[i] instanceof Integer) {
				System.out.println((int)list[i]+ + 100);
			}
		}
		
		list[0] = 100;
		list[1] = 222;
		list[2] = 333;
		list[3] = 444;
		list[4] = 555;
//		배열은 같은 타입에 같은 자료형의 값을 넣을 것
		
	}
}

class AAA {	// extends Object
	public int a;
}

class BBB extends AAA {
	public int b;
}

class CCC extends BBB {
	public int c;
}