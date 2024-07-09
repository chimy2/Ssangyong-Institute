package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex53_HashSet {
	public static void main(String[] args) {
		/*
		 * 1. List
		 * 	- 순서가 있는 집합
		 * 	- 첨자(방번호)
		 *  - 데이터 중복을 허용
		 * 	
		 * 2. Map
		 * 	- 순서가 없는 집합
		 * 	- 키(방이름)
		 *  - 데이터 중복을 허용
		 * 
		 * 3. Set
		 * 	- 순서가 없는 집합
		 * 	- 식별자가 없다.(방번호X, 방이름X) > 방을 구분할 수 없다.
		 * 	- 데이터 중복을 허용 않음(🌟🌟🌟)
		 * 
		 * 
		 * 집합 선택?
		 * 1. 순수 배열 비슷한 상황 > ArrayList
		 * 2. 요소 구분 > 이름 > 가독성 > HashMap
		 * 3. 요소 중복 허용X > HashSet
		 */
		
//		m1();
//		m2();
//		m3();
		m4();
	}

	private static void m4() {
//		🌟🌟🌟 Set + Object
		HashSet<String> set1 = new HashSet<String>();
		
		set1.add("홍길동");
		set1.add("아무개");
		set1.add("하하하");
		
		set1.add("홍길동");
		
		System.out.println(set1);
		
//		회원 명단
//		Member[] list;
//		ArrayList<Member> list;
		
//		중복된 회원(Member) > 배제
		HashSet<Member> set2 = new HashSet<Member>();
		
		set2.add(new Member("홍길동", 20));	//해시코드로 구분
		set2.add(new Member("아무개", 22));
		set2.add(new Member("하하하", 25));
		
		set2.add(new Member("홍길동", 20));	
//		비교할 때 객체.equals(객체)로 비교하는데 
//		hashcode와 equals를 재정의 해줬기 때문에 같은 객체로 인식함
		
		System.out.println(set2);
		System.out.println();
		
		Member m1 = new Member("홍길동", 20);
		Member m2 = new Member("아무개", 22);
		Member m3 = new Member("홍길동", 20);
		
//		주소값(참조형) 변수의 비교는 연산자 사용하지 말것 > equals
		System.out.println(m1 == m2);		//false
		System.out.println(m1.equals(m2));	//false
		
		System.out.println(m1 == m3);		//false	> 연산자는 바꾸지 못함
		System.out.println(m1.equals(m3));	//true > 메소드를 재정의해서 true로 만들어줌
		
		System.out.println("m1: " + m1.hashCode());	//498603628
		System.out.println("m2: " + m2.hashCode());	//863217391
		System.out.println("m3: " + m3.hashCode());	//498603628
//		Object.hashcode()
//		- 메모리 주소번지를 돌려주는 메소드
//		- 본인을 식별하기 위해 사용하는 도구
		
	}

	private static void m3() {
//		List vs Set
		
//		마트 경품 추첨
//		- 중복 당첨 허용O
//		- 중복 당첨 허용X
		
		String[] list = { "홍길동", "아무개", "하하하", "호호호", "강아지", "고양이", "병아리", "호랑이", "사자", "햄스터" };
		
		Random rnd = new Random();
		
//		당첨자 > 배열 저장
//		- 중복 당첨 허용O
		ArrayList<String> result1 = new ArrayList<String>();
		
		for(int i=0; i<5; i++) {
			result1.add(list[rnd.nextInt(list.length)]);
		}
		
		System.out.println(result1);
		
//		당첨자 > 배열 저장
//		- 중복 당첨 허용X
		HashSet<String> result2 = new HashSet<String>();
		
		while(result2.size() < 5) {
			result2.add(list[rnd.nextInt(list.length)]);
		}
		
		System.out.println(result2);
	}

	private static void m2() {
//		로또 번호 > 난수 + 유일한 숫자들만..
		
//		6 + 1~45
		for(int i=0; i<10; i++) {
			System.out.println((int)(Math.random() * 45) + 1);
		}
		
		Random rnd = new Random();
		for(int i=0; i<10; i++) {
//			System.out.println(rnd.nextDouble());	//Math.random();
//			System.out.println(rnd.nextInt());
//			System.out.println(rnd.nextInt(10));	//0~9
//			System.out.println(rnd.nextBoolean());
		}
		
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		for(int i=0; i<6; i++) {
			int n = rnd.nextInt(45) + 1;
			
//			중복 검사
			if(check(lotto, n)) {
				lotto.add(n);
			} else {
				i--;
			}
			
		}
		
		lotto.clear();
		
		while(lotto.size() < 6) {
			int n = rnd.nextInt(45) + 1;
			
			if(check(lotto, n)) {
				lotto.add(n);
			}
		}
		
		System.out.println(lotto);
		
		HashSet<Integer> lotto2 = new HashSet<Integer>();
		
		while(lotto2.size() < 6) {
			int n = rnd.nextInt(45) + 1;
			lotto2.add(n);
		}
		
		System.out.println(lotto2);
	}

	private static boolean check(ArrayList<Integer> lotto, int n) {
		for(int i=0; i<lotto.size(); i++) {
			if(lotto.get(i) == n) {
				return false;	//중복O
			}
		}
		return true;	//유일O
	}

	private static void m1() {
		HashSet<String> set = new HashSet<String>();
		
		System.out.println(set);
		
//		1. 요소 추가
		set.add("사과");
		set.add("딸기");
		set.add("바나나");

//		2. 요소 개수
		System.out.println(set.size());
		
//		3. 요소 읽기 > 메서드 제공 안함
//		- 읽기 도구 제공 > Iterator(반복자) == 향상된 for문
		Iterator<String> iter = set.iterator();
		
		System.out.println(iter.hasNext());	//읽어올 다음 데이터가 있냐?
		System.out.println(iter.next());	//읽어라
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("다시 읽기");
		
		iter = set.iterator();	//새로운 반복기 생성 > 커서는 BOF에서 다시 시작
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
//		향상된 for 문 > 내부에 iterator 구현
		for(String item : set) {
			System.out.println(item);
		}
		
		for(String item : set) {
			System.out.println(item);
		}
		
		set.add("사과");
		
		System.out.println(set);
		
	}
}

class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", this.name, this.age);
	}
	
	@Override
	public int hashCode() {
//		System.out.println("홍길동20".hashCode());	//498603628
//		System.out.println("아무개25".hashCode());	//863217391
//		System.out.println("홍길동20".hashCode());	//498603628
		return (this.name + this.age).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
//		이름과 나이가 동일하면 같은 객체로 판단하겠다.
		return this.hashCode() == obj.hashCode();
	}
}