package com.test.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Ex58_TreeSet {
	public static void main(String[] args) {
		/*
		 * [컬렉션 이름]	> [물리구조]		[사용법 = 인터페이스 or 특징(용도)]
		 * ArrayList	> Array			List
		 * LinkedList	> Linked		List
		 * HashSet		> Hash			Set
		 * TreeSet		> Tree			Set
		 * HashMap		> Hash			Map
		 * TreeMap		> Tree			Map
		 * 
		 * TreeSet
		 * - 순서가 없다
		 * - 중복값을 가지지 않는다.
		 * - 이진 탐색 트리 구조, Binary Search Tree
		 * 	- 내부 데이터가 정렬이 되어있는 구조로 저장
		 * 
		 */
		
		HashSet<String> names = new HashSet<String>();
		
		names.add("홍길동");
		names.add("아무개");
		names.add("강아지");
		names.add("고양이");
		names.add("병아리");
		names.add("홍길동");
		
		System.out.println(names);
		
		TreeSet<String> names2 = new TreeSet<String>(names);
		
		System.out.println(names2);
		
//		Set > (변환) > List
		ArrayList<String> list = new ArrayList<String>(names);
		
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		set.add(6);
		set.add(2);
		set.add(5);
		set.add(8);
		set.add(1);
		set.add(9);
		set.add(3);
		set.add(4);
		set.add(10);
		set.add(0);
		
		System.out.println(set.size());
		System.out.println(set);
		
		for(int n : set) {
			System.out.println(n);
		}
		System.out.println();
		
//		범위 관련 기능 제공
		System.out.println(set.first());
		System.out.println(set.last());
		
		System.out.println(set.headSet(3));	//미만
		System.out.println(set.tailSet(7));	//초과
		System.out.println(set.subSet(3, 7));	// 3이상 7미만
	}
}
