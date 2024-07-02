package com.test.java.array;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

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
//		m9();
//		m10();
//		m11();
//		m12();
//		m13();
//		m14();
//		m15();
//		m16();
//		m17();
//		m18();
//		m19();
		m20();
	}

	private static void m20() {
		int[][] nums = new int[5][5];
//		입력
		int n = 1;
		
		for(int i=0; i<nums.length - 1; i++) {
			for(int j=0; j<nums[i].length - 1; j++) {
				nums[i][j] = n;
				
				nums[i][4] += n;
				
				nums[4][j] += n;
				
				nums[4][4] += n;
				
				n++;
			}
		}
		
//		출력
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
			System.out.println();
		}
	}

	private static void m19() {
//		배열 > 요소 삭제 > Left Shift 구현
		int[] list = { 5, 6, 1, 3, 2, 4, 8, 7, 9, 3 };
		
		int index = -1;	//삭제 위치
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제 위치: ");
		index = scan.nextInt();
		
		System.out.println("원본: " + Arrays.toString(list));
		
//		삭제 구현
		for(int i=index; i<list.length - 1; i++) {
			list[i] = list[i + 1];
		}
		
		list[list.length - 1] = 0;
		
		System.out.println("결과: " + Arrays.toString(list));
	}

	private static void m18() {
//		배열 > 요소 삽입 > Right Shift 구현
		int[] list = { 5, 6, 1, 3, 2, 4, 0, 0, 0, 0 };
		
		int index = -1;	//삽입 위치
		int value = 0;	//삽입 값
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삽입 위치: ");
		index = scan.nextInt();
		
		System.out.print("값: ");
		value = scan.nextInt();
		
		System.out.println("원본: " + Arrays.toString(list));
		
//		삽입 구현
		for(int i=list.length - 2; i>=index ; i--) {
			list[i + 1] = list[i];
		}
		
		list[index] = value;
		
		System.out.println("결과: " + Arrays.toString(list));
	}

	private static void m17() {
		int[][] nums = new int[5][5];
		
//		입력 (문제에 따른 구현 코드)
		int n = 1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<i+1; j++) {
				nums[i][j] = n++;
			}
		}
		
//		출력(지금 코드만 사용 > 수정 금지) Q70~Q74
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d", nums[i][j]);
			}
			System.out.println();
		}
	}

	private static void m16() {
//		1~10
		for(int i=0; i<5; i++) {
			System.out.println((int)(Math.random() * 10) + 1);
		}
	}

	private static void m15() {
//		🌟🌟🌟 배열의 길이는 불변이다.
//		- 한번 만들어진 배열 방의 개수(길이)는 더 늘리거나 삭제할 수 없다.
//		- 배열은 항상 미리 예측해서 적절한 길이로 생성한다.(🌟🌟🌟)
//		- 배열의 길이를 동적으로 정할 수 있다.(🌟🌟🌟🌟🌟)
		
//		int[] kor = new int[300];	//정적 길이(소스 상에 고정으로 기재)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생수: ");
		int length = scan.nextInt();
		
		int[] kor = new int[length];	//동적 길이
										// > 미리 정하지 않고 실행 시 크기를 정해서 동적이라고 함
		
		System.out.println(kor.length);
	}

	private static void m14() {
//		초기화 리스트
		int[] nums1 = { 10, 20, 30 };	// 배열 리터럴
		
		int[][] nums2 = { { 10, 20, 30 }, { 40, 50, 60 } };
		int[][][] nums3 = { 
				{ { 10, 20, 30 }, { 40, 50, 60 } },
				{ { 70, 80, 90 }, { 100, 110, 120 } }
		};
	}

	private static void m13() {
//		배열의 차원
//		- 1차원 배열, 2차원 배열, 3차원 배열..
		
//		1차원 배열
		int[] nums1 = new int[3];
		
		nums1[0] = 10;
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(Arrays.toString(nums1));
		
//		2차원 배열
		int[][] nums2 = new int[2][3];	//2행 3열
		
		nums2[0][0] = 10;
		nums2[0][1] = 20;
		nums2[0][2] = 30;
		
		nums2[1][0] = 40;
		nums2[1][1] = 50;
		nums2[1][2] = 60;
		
		System.out.println(Arrays.toString(nums2));	//1차원 배열에서만 사용
		System.out.println(Arrays.deepToString(nums2));	//2차원 배열이상에서 사용
		
		for(int i=0; i<2; i++) {	//층(행)
			for(int j=0; j<3; j++) {	//호(열)
				System.out.print(nums2[i][j] + "\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<nums2.length; i++) {
			System.out.println(Arrays.toString(nums2[i]));
		}
		
//		3차원 배열
		int[][][] nums3 = new int[2][2][3];
		
		nums3[0][0][0] = 10;
		nums3[0][0][1] = 20;
		nums3[0][0][2] = 30;
		
		nums3[0][1][0] = 40;
		nums3[0][1][1] = 50;
		nums3[0][1][2] = 60;
		
		nums3[1][0][0] = 70;
		nums3[1][0][1] = 80;
		nums3[1][0][2] = 90;
		
		nums3[1][1][0] = 100;
		nums3[1][1][1] = 110;
		nums3[1][1][2] = 120;
		
		for(int i=0; i<nums3.length; i++) {	//동
			for(int j=0; j<nums3[i].length; j++) {	//층
				for(int k=0; k<nums3[i][j].length; k++) {	//호
					System.out.printf("%5d", nums3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println(Arrays.deepToString(nums3));
	}

	private static void m12() {
		int[] nums = { 5, 3, 1, 4, 2 };
		String[] names = {"홍길동", "강감찬", "이율곡", "허준", "강아지", "고양이", "닭"};
		
//		정렬(오름차순) > Quick Sort(퀵정렬)
		Arrays.sort(nums);
		Arrays.sort(names);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(names));
		
		nums = new int[]{ 5, 3, 1, 4, 2, 6, 8, 7, 9, 10, 0};
		Arrays.sort(nums, 3, 7);
		System.out.println(Arrays.toString(nums));
//		[5, 3, 1, 2, 4, 6, 8, 7, 9, 10, 0]
	}

	private static void m11() {
		String s1 = "홍길동";
		String s2 = "강감찬";
		
//		문자열 > 문자 추출 > 문자 코드값
//		System.out.println(s1.charAt(첨자));
//		System.out.println(s1.charAt(0) > s2.charAt(0));
		System.out.println(s1.compareTo(s2));	//10808
		System.out.println(s2.compareTo(s1));	//-10808
		
//		compareTo 반환값
//		- 양수: s1 크다
//		- 음수: s2 크다
//		- 0: s1과 s2가 동일하다
		
		String[] names = {"홍길동", "강감찬", "이율곡", "허준", "강아지", "고양이", "닭"};
		String temp = "";
		
		for(int i=0; i<names.length - 1; i++) {
			for(int j=0; j<names.length - i - 1; j++) {
				if(names[j].compareTo(names[j + 1]) > 0) {
					temp = names[j];
					names[j] = names[j + 1];
					names[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(names));
		
		for(int i=0; i<names.length - 1; i++) {
			for(int j=0; j<names.length - i - 1; j++) {
				if(names[j].compareTo(names[j + 1]) < 0) {
					temp = names[j];
					names[j] = names[j + 1];
					names[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(names));
	}

	private static void m10() {
//		배열 > 사용 업무 > 정렬
//		- 크기 비교 후 > 요소간의 재배치
		
//		1. 오름차순
//			a. 숫자: 작은수 > 큰수
//			b. 문자열: 문자코드값 순서대로 
//			c. 날짜시간: 과거 > 미래
		
//		2. 내림차순
//			a. 숫자 : 큰수 > 작은수
//			b. 문자열: 문자코드값 역순서대로
//			c. 날짜시간: 미래 > 과거
		
//		정렬 구현
//		1. 직접 구현 > 정렬 알고리즘
//		2. JDK 제공
		
//		정렬 > swap > 두 공간의 값을 바꾸는 행동
		int a = 10;
		int b = 5;
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
//		버블 정렬

		int[] nums = { 5, 3, 1, 4, 2 };

		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
//				i(0) > j(0,1,2,3)
//				i(1) > j(0,1,2)
//				i(2) > j(0,1)
//				i(3) > j(0)
				
//				왼쪽방 vs 오른쪽방
//				0 vs 1
//				1 vs 2
//				2 vs 3
//				3 vs 4
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}//if
//				System.out.println(Arrays.toString(nums));
			}//for j
//			System.out.println();
		}//for i
		System.out.println(Arrays.toString(nums));
		
		for (int i=0; i<nums.length - 1; i++) {
			for (int j=0; j<nums.length - i - 1; j++) {
				if(nums[j] < nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
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
