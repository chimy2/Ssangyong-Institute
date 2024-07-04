package com.test.java.obj.inheritance;

public class Ex38_Object {
	public static void main(String[] args) {
		/*
		 * Object 클래스
		 * - 개발자가 선언하는 모든 클래스는 자동으로 Object 클래스를 상속받는다.
		 * - 모든 클래스의 근원 클래스 > 루트 클래스(Root)
		 * - Object 클래스 멤버 9개 > 상속 > 모든 클래스는 상속받은 9개를 가지고 있다.(공통 기능)
		 */
		
		Object o1 = new Object();
//		Class Object is the root of the class hierarchy.
//		Every class has Object as a superclass. 
//		All objects, including arrays, implement the methods of this class.
		
		Test t1 = new Test();
		
		t1.a = 10;
		t1.b = 10;
		
		int[] nums = new int[3];
		
	}
}
//기본적으로 extends Object가 생략되어있음
class Test extends Object {
	public int a;
	public int b;
	public void ccc() {}
}