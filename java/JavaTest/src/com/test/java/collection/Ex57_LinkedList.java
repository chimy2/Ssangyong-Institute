package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex57_LinkedList {
	public static void main(String[] args) {
		/*
		 * Collection(I) < List(I) < ArrayList(C), LinkedList(C)
		 * Collection(I) < Set(I) < HashSet(C)
		 * 
		 * ArrayList vs LinkedList
		 * - 메서드 구성 유사 > 사용법이 아주 유사하다.
		 * - 내부 구조가 다르다. > 사용 용도가 다르다.
		 * 
		 * LinkedList 종류
		 * 1. LinkedList
		 * 2. Double LinkedList
		 * 3. Double Circular LinkedList > 순환구조 > 자바의 LinkedList
		 * 
		 * 
		 * ArrayList(배열)
		 * - 순차적인 추가/삭제 > 양호(최강)
		 * - 읽기 > 최강
		 * - 중간 추가/삭제 > 불량(최약) > Shift
		 * 
		 * LinkedList
		 * - 순차적인 추가/삭제 > 양호
		 * - 중간 추가/삭제 > 양호
		 */
		
//		m1();
		m2();
	}

	private static void m2() {
//		입출력 속도 비교
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		long begin = System.nanoTime();
		System.out.println(begin);
		
		long end = System.nanoTime();
		System.out.println(end);
		
//		1. 순차적으로 데이터 추가하기, Append
		System.out.println("[1. 순차적으로 데이터 추가하기, Append]");
		
		begin = System.currentTimeMillis();
		
		for(int i=0; i<10000000; i++) {
			list1.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);
		
		begin = System.currentTimeMillis();
		
		for(int i=0; i<10000000; i++) {
			list2.add(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);
		
		
//		2. 중간에 데이터 추가하기, Insert
		System.out.println("[2. 중간에 데이터 추가하기, Insert]");
		
		begin = System.currentTimeMillis();

		for(int i=0; i<1000; i++) {
			list1.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);
		
		begin = System.currentTimeMillis();
		
		for(int i=0; i<1000; i++) {
			list2.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);
		
//		3. 중간에 데이터 삭제하기, delete
		System.out.println("[1. 순차적으로 데이터 추가하기, Append]");
		
		begin = System.currentTimeMillis();
		
		for(int i=list1.size() - 1; i>=0; i--) {
			list1.remove(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);
		
		begin = System.currentTimeMillis();
		
		for(int i=0; i<1000; i++) {
			list2.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);
		
//		4. 순차적으로 데이터 삭제하기, delete
		System.out.println("[4. 순차적으로 데이터 삭제하기, delete]");
		
		begin = System.currentTimeMillis();
		
		for(int i=list2.size() - 1; i>=0; i--) {
			list2.remove(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("ArrayList 작업 시간: %,dms\n", end - begin);
		
		begin = System.currentTimeMillis();
		
		for(int i=0; i<1000; i++) {
			list2.add(0, i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.printf("LinkedList 작업 시간: %,dms\n", end - begin);
		
	}

	private static void m1() {
//		사용법?
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		System.out.println(list1.get(0));
		System.out.println(list2.get(0));
		
		for(int n : list1) {
			System.out.println(n);
		}
		
		for(int n : list2) {
			System.out.println(n);
		}
		
	}
}
