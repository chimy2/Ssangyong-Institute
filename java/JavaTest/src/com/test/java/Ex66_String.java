package com.test.java;

public class Ex66_String {
	public static void main(String[] args) {
		/*
		 * 문자열은 불변(Immutable)이다.
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
	}

	private static void m5() {
		
	}

	private static void m4() {
//		문자열
//		1. String 클래스
//		2. StringBuilder 클래스
		
		String s1 = "홍길동";	//혜택
		String s2 = new String("홍길동");
		
//		조작 > 비용X
		StringBuilder s3 = new StringBuilder("홍길동");
		System.out.println(s3);
		System.out.println(s3.length());
		System.out.println(s3.indexOf("홍"));
		
		long begin = 0, end = 0;
		
		begin = System.currentTimeMillis();
		
		String txt1 = "홍길동";
		
		for(int i=0; i<100000; i++) {
			txt1 += ".";
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("길이: %,d자\n시간: %,dms\n", txt1.length(), end - begin);

		begin = System.currentTimeMillis();
		
		StringBuilder txt2 = new StringBuilder("홍길동");
		
		for(int i=0; i<100000; i++) {
			txt2.append(".");	//txt2 += ".";
		}
		
		end = System.currentTimeMillis();
		System.out.printf("길이: %,d자\n시간: %,dms\n", txt2.length(), end - begin);
	}

	private static void m3() {
//		문자열의 잦은 조작 > 금지!!
		String txt = "홍길동";
		
		for(int i=0; i<10000; i++) {
			txt += ".";
		}
		
		System.out.println(txt);
		
//		커다란 문자열의 수정 > 금지!!
		txt = "홍길동".repeat(1000);
		
		txt += ".";
		
		System.out.println(txt);
	}

	private static void m2() {
//		자료형 > int[]
		int[] nums1 = new int[5];
		int[] nums2 = new int[10];
		
//		자료형 > String
		String txt1 = "홍길동";
		String txt2 = "홍길동";
		
		System.out.println(txt1.hashCode());
		System.out.println(txt2.hashCode());
//		값형
//		공간이 곧 데이터를 저장
//		어떤 데이터를 넣건 자료형에 따라 일정한 메모리 크기를 가짐
		
//		참조형
//		힙 어딘가에 저장되어 있는 데이터의 공간을 저장하는 자료형
//		실제 공간의 크기가 달라짐 > 자료형만가지고 메모리의 크기를 추측할 수 없다
//		상황에 따라 메모리크기가 달라지는 자료형이라서 자유로운 힙이라는 공간에 할당함
	}

	private static void m1() {
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = "홍";
		name3 += "길동";
		
		System.out.println(name1);	//홍길동
		System.out.println(name2);	//홍길동
		System.out.println(name3);	//홍길동
		
		System.out.println(name1 == name2);	//true
		System.out.println(name1 == name3);	//false
		
		System.out.println(name1.equals(name2));	//true
		System.out.println(name1.equals(name3));	//true
		
//		문자열은 불변(Immutable)이다.
		String txt = "홍길동";
		txt += "님";		//수정 작업이 불가능하다.
		System.out.println(txt);
	}
}

class Item {
	private int num;
	private String type;
	
	@Override
	public String toString() {
		return String.format("Item [num=%s, type=%s]", num, type);
	}
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Item [num=").append(num).append(", type=").append(type).append("]");
//		return builder.toString();
//	}
	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Item [num=");
//		builder.append(num);
//		builder.append(", type=");
//		builder.append(type);
//		builder.append("]");
//		return builder.toString();
//	}
	
//	@Override
//	public String toString() {
//		return "Item [num=" + num + ", type=" + type + "]";
//	}
}