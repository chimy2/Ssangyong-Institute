package com.test.java.array;

import java.util.Arrays;
import java.util.Calendar;

public class Ex25_Array {
	public static void main(String[] args) {
		/*
		 * 배열, Array
		 * - 데이터 저장하는 자료구조
		 * - 데이터의 집합 > 변수들을 모아놓은 집합
		 * - 같은 성격의 같은 자료형을 저장하는 데이터 집합
		 * 
		 * - 배열 + 반복문
		 */
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
		m9();
	}

	private static void m9() {
//		배열의 초기화 리스트
		int[] nums1 = new int[5];
		
		for(int i=0; i<nums1.length; i++) {
			nums1[i] = (i + 1) * 10;
		}
		
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = new int[5];
		
		nums2[0] = 97;
		nums2[1] = 54;
		nums2[2] = 76;
		nums2[3] = 88;
		nums2[4] = 60;
		
		int[] nums3 = new int[] {97, 54, 76, 88, 60};
		int[] nums4 = {97, 54, 76, 88, 60};
		
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(nums3));
		System.out.println(Arrays.toString(nums4));
		
		String[] names = { "홍길동", "아무개", "하하하", "호호호" };
		
		System.out.println(Arrays.toString(names));
	}

	private static void m8() {
//		Arrays 클래스
//		- 유틸리티 클래스
//		- 배열과 관련된 여러가지 기능을 구현한 클래스
		
		int[] nums = new int[3];
		
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
//		배열 상태 확인
		System.out.println(nums);
//		[I @ 5aaa6d82
//		자료형 @ 주소값
//		[ - 배열, I - int, 해쉬처리된 주소값
		
		printArray(nums);
		
		System.out.println(Arrays.toString(nums));	
		//내용물을 보여준다 > dump(덤프)한다
		
//		Arrays > 깊은 복사
//		to the final index of the range to be copied, 
//		exclusive.(This index may lie outside the array.)
//		자바에서 범위를 잡을 때 처음 위치는 포함, 마지막 위치는 그 전인 경우가 많음
		int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
		
		nums[0] = 111;
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(copy));
	}

	private static void printArray(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	private static void m7() {
//		배열 복사
//		1. 얕은 복사, Shallow Copy > 기본 동작
//		- 주소값 복사 
		
//		2. 깊은 복사, Deep Copy
//		- 요소 복사(실제 값 복사)
		
		int[] nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 20;
		
		int[] copy = new int[3];
		
//		얕은 복사(주소값 복사)
//		copy = nums;
		
//		깊은 복사(값 복사)
//		int = int 값복사
		copy[0] = nums[0];
		copy[1] = nums[1];
		copy[2] = nums[2];
		
		for(int i=0; i<nums.length; i++) {
			copy[i] = nums[i];
		}
		
		nums[0] = 111; 
		
		System.out.println(nums[0]);	//111
		System.out.println(copy[0]);	//10
	}

	private static void m6() {
		int a = 10;
		changeValue(a);
		System.out.println("a: " + a);	//a: 10
//		물리적으로 분리되어 있는 값형인 지역변수이기 때문에 변하지 않음
//		서로 다른 삶을 살아감
//		또다른 스택 공간에 변수만들어져서 값이 복사됨
		
		int[] b = new int[3];
		b[0] = 10;
		changeArray(b);
		System.out.println("b[0]: " + b[0]);	//b[0]: 20
//		주소값이 같기 때문에 참조형인 지역변수를 넘겨서 값을 변경하면
//			Side Effect가 발생한다
//		또다른 스택 공간에 변수가 만들어져서 값이 복사되지만
//		같은 주소값을 갖기 때문에 참조하는 주소값이 같아서
//		값을 변경하면 원본 배열의 주소값을 참조하여 그 값을 직접 변경
	}

	private static void changeArray(int[] b) {
		b[0] = 20;
	}

	private static void changeValue(int a) {
		a = 20;
	}

	private static void m5() {
//		배열 복사(모든 참조형 복사)
		
//		값형 복사
		int a = 10;
		int b;
		
		b = a;
		
		System.out.println("a: " + a);	//10
		System.out.println("b: " + b);	//10
		
//		값형 > 메모리의 물리적인 형태 때문에 
//			원본을 수정해도 복사본에 영향을 주지 않는다
//			> Side Effect가 발생하지 않음.
		a = 20;	//원본 수정
		
		System.out.println("a: " + a);	//20
		System.out.println("b: " + b);	//10
		
		int[] nums = new int[3];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
//		참조형 > 원본을 수정하면 복사본도 수정된다.
//			> Side Effect가 발생함.(주의)
		int[] copy = nums;
		System.out.println(copy[0]);	//10
		System.out.println(copy[1]);	//20
		System.out.println(copy[2]);	//30
		
		nums[0] = 111;
		nums[1] = 222;
		nums[2] = 333;
		
		System.out.println(nums[0]);	//111
		System.out.println(copy[0]);	//111
		System.out.println(copy[1]);	//222
		System.out.println(copy[2]);	//333
		
		/*
		 * Stack
		 * 지역 변수 저장
		 * 배열은 연속된 공간을 할당받기 때문에 
		 * heap영역에 있는 첫번째 주소값을 저장
		 * 주소값을 참조해서 원본을 찾아가기 때문에 참조형이라고 부른다 
		 * 
		 * (managed) Heap
		 * 배열이 할당받은 실질적 공간이 저장됨
		 */
	}

	private static void m4() {
//		각 자료형 > 배열 만들기
		
//		정수 배열(byte, short, int, long)
		byte[] list1 = new byte[5];
		list1[0] = 10;
		System.out.println(list1[0]);

//		실수 배열(float, double)
		double[] list2 = new double[5];
		list2[0] = 3.14;
		System.out.println(list2[0]);
		
//		문자 배열(char) = String
		char[] list3 = new char[5];
		list3[0] = 'A';
		System.out.println(list3[0]);
		
//		논리 배열
		boolean[] list4 = new boolean[5];
		list4[0] = true;
		System.out.println(list4[0]);
		
//		참조형 배열
		String[] list5 = new String[5];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		
		Calendar[] list6 = new Calendar[5];	//Calendar 변수를 담을 공간 x 5개
		list6[0] = Calendar.getInstance();
		System.out.println(list6[0]);
	}

	private static void m3() {
//		방 1개: 배열의 요소(Element)
//		방번호: 배열의 인덱스(Index), 첨자
//		방개수: 배열의 길이(Length)
		
//		모든 참조형의 특징
//		- 할당된 공간을 초기화하지 않아도, 자동으로 초기화가 된다.
		
//		배열의 자동 초기화
//		- int[] 	> 모든 방을 0으로 초기화
//		- double[] 	> 모든 방을 0.0으로 초기화
//		- char[] 	> 모든 방을 '\0'으로 초기화
//		- boolean[] > 모든 방을 false로 초기화
//		- String[] 	> 모든 방을 null으로 초기화
		
		int[] nums = new int[5];
		
//		nums[0] = 10;
//		nums[1] = 20;
//		nums[2] = 30;
//		nums[3] = 40;
//		nums[4] = 50;
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		
//		Index 5 out of bounds for length 5
//		System.out.println(nums[5]);
		
//		배열 탐색 > for문 사용 
		for(int i=0; i<nums.length; i++) {
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
		}
		
//		배열 길이 = 5
//		첨자 범위 = 0 ~ 4
//		첨자 범위 = 0 ~ 길이 - 1
	}

	private static void m2() {
//		요구사항] 학생 3명 > 국어 점수 > 총점, 평균
//		요구사항] 학생수 증가 > 300명
		
//		배열 선언하기
//		- 자료형[] 변수명 = new 자료형[길이];
//		- 배열타입 배열명 = new 배열타입[배열의 길이]; 
		int[] kors = new int[300];
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
//		+297
		
//		int total = kors[0] + kors[1] + kors[2];
		
//		int index = 0;
//		kors[index] = 100;
		
		int total = 0;
		
		for(int i=0; i<kors.length; i++) {
//			total += kors[방번호];
			total += kors[i];
		}
		
		double avg = (double) total / kors.length;
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
	}

	private static void m1() {
//		요구사항] 학생 3명 > 국어 점수 > 총점, 평균
//		요구사항] 학생수 증가 > 300명
		
		int kor1;
		int kor2;
		int kor3;
//		+ 297 변수 추가 선언		
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
//		+ 297
		
		int total = kor1 + kor2 + kor3;	// + kor4 + kor5 + .. + kor300
		double avg = total / 3.0;	// / 300.0
		
		System.out.printf("총점: %d점, 평균: %.1f점\n", total, avg);
		
	}
}
