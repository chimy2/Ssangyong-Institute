package com.lesson.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex52_HashMap {
	
	public static void main(String[] args) {
		
		//Ex52_HashMap.java
		/*
		
			List > ArrayList
			Map > HashMap
			
			
			ArrayList
			- 요소 접근 > 첨자(index) 사용 > 방번호 사용
			- 순서가 있는 집합(순서 == 방번호)
			ex) 1강의실, 2강의실, 3강의실..
			- 스칼라 배열(scalar array)
			- 요소 = 첨자(index) + 값(value)
			- 첨자(index)는 유일하다.
			- 값(value)은 중복이 가능하다.
			
			
			HashMap
			- 요소 접근 > 키(key) 사용 > 방이름 사용, 방번호(X)
			- 순서가 없는 집합
			ex) 햇님반, 달님반, 별님반
			- 연관 배열, 사전 구조(Dictionary)
			- 요소 = 키(key) + 값(value)
			- 키(key)는 유일하다.
			- 값(value)은 중복이 가능하다.
		
		*/
		
		//m1();
		m2();
		
	}//main

	private static void m2() {
		
		HashMap<String,Integer> map1 = new HashMap<>();
		map1.put("방이름", 100);
		
		HashMap<Boolean,String> map2 = new HashMap<>();
		map2.put(true, "참");
		map2.put(false, "거짓");
		
		HashMap<Integer,String> map3 = new HashMap<>();
		map3.put(1, "하나");
		map3.put(2, "둘");
		System.out.println(map3.get(1));
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		//1. 요소 추가
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blud", "파랑");
		
		//2. 요소 개수
		System.out.println(map.size());
		System.out.println(map); // red=빨강 > Entry
		
		//3. 요소 읽기
		System.out.println(map.get("red"));
		System.out.println(map.get("yellow"));
		System.out.println(map.get("blue"));
		
		//4. 요소 수정
		//- key: 식별자(수정 불가)
		//- value: 값(수정 가능)
		map.put("yellow", "옐로우");
		System.out.println(map);
		
		//5. 요소 삭제
		//- 방번호(X) > Shift X
		map.remove("yellow");
		System.out.println(map.get("yellow"));
		System.out.println(map.size());
		System.out.println(map);
		
		//6. 검색
		//- ArrayList.indexOf()
		//- HashMap.indexOf() > X
		System.out.println(map.containsKey("red"));
		System.out.println(map.containsValue("빨강"));
		
		//7. 초기화
		map.clear();
		System.out.println(map);
		
	}

	private static void m1() {
		
		//학생 1명 > 국어,영어,수학 점수 저장 > 어떤 데이터 집합?
		
		//1. 배열
		//2. ArrayList
		
		//4. Class
		//3. HashMap
		
		
		
		//1. 배열
		//- 집합
		//- 첨자는 의미가 없다. > 각각의 방이 무슨 데이터인지 파악이 힘들다.
		int[] s1 = new int[3];
		
		s1[0] = 100;
		s1[1] = 90;
		s1[2] = 80;
		
		System.out.println(s1[0] + s1[1] + s1[2]);
		
		
		//2. ArrayList
		//- 집합
		//- 방번호가 무슨 과목??
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		
		s2.add(100);
		s2.add(90);
		s2.add(80);
		
		System.out.println(s2.get(0) + s2.get(1) + s2.get(2));
		
		
		//4. Class
		Score s3 = new Score(100, 90, 80);
		
		s3.setMath(88);
		
		System.out.println(s3.getTotal());
		
		
		//3. HashMap
		HashMap<String,Integer> s4 = new HashMap<String,Integer>();
		
		s4.put("kor", 100);
		s4.put("eng", 90);
		s4.put("math", 80);
		
		System.out.println(s4.get("kor") + s4.get("eng") + s4.get("math"));
		
		
	}

}


class Score {
	
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		this.kor = 0;
		this.eng = 0;
		this.math = 0;
	}
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {
		return this.kor + this.eng + this.math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
}














