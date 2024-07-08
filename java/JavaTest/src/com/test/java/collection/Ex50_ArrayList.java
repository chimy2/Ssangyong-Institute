package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex50_ArrayList {
	public static void main(String[] args) {
		/*
		 * 1. 제어문
		 * 2. 배열 > 컬렉션
		 * 3. 클래스
		 * 
		 * 컬렉션, Collection
		 * - JCF, Java Collection Framework
		 * - (향상된) 배열
		 * - 향상? 
		 * 	1. 성능 향상(??)
		 * 	2. 사용법 향상 > 업무의 목적에 따른 배열의 사용법을 다양하게 제공
		 * 	3. 길이 가변 > 배열의 길이가 늘었다 줄었다 가능
		 * 
		 * 
		 * 컬렉션 종류
		 * 1. List 계열
		 * 	- ArrayList(🌟🌟🌟🌟🌟)
		 * 	- LinkedList
		 *  - Queue
		 *  - Stack
		 *  - Vector(-, legacy)
		 * 
		 * 2. Set 계열
		 * 	- HashSet(🌟🌟🌟🌟🌟)
		 * 	- TreeSet
		 * 
		 * 3. Map 계열
		 *	- HashMap(🌟🌟🌟🌟🌟)
		 *	- TreeMap
		 *	- Properties
		 *	- HashTable(-, legacy)
		 *
		 * ArrayList 클래스
		 * 	- 순수 배열의 구조와 거의 유사함
		 * 	
		 */
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
		m7();
	}

	private static void m7() {
//		배열의 길이 > 불변
//		컬렉션의 길이 > 가변
		
		int[] list = new int[4];
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();	
//		Arraylist 생성 시 4칸짜리 배열 생성 
//		> 배열의 크기가 모자랄 때마다 원 배열을 복사하고 원 배열의 크기의 2배 만큼의 크기의 배열을 새로 생성
		
		for(int i=0; i<10; i++) {
			list2.add(i);
		}
		
//		list2.trimToSize();
//		> 메모리 공간을 아끼기 위해 데이터가 있는 크기 만큼 배열을 잘라서 배열을 새로 생성
//		> 이처럼 배열의 크기를 줄일 수도 있으나 잘 사용하지는 않음
		
		System.out.println(list2);
	}

	private static void m6() {
//		선택? > 데이터 집합?
//		1. 배열			> 길이 고정 > 학생수 정확(고정)	> 속도 빠름
//		2. ArrayList	> 길이 가변 > 학생수 불명확		> 배열에 비해 느림
		
//		성적표 > 학생 집합
		ArrayList<Student> list = new ArrayList<Student>();
		String[] names = { "홍길동", "아무개", "강아지", "고양이", "병아리" };
		
		for(int i=0; i<5; i++) {
			Student s = new Student();
			s.setNo(i + 1);
			s.setName(names[i]);
//			60~100
			s.setKor((int)(Math.random() * 41) + 60);
			s.setEng((int)(Math.random() * 41) + 60);
			s.setMath((int)(Math.random() * 41) + 60);
			
//			s.setTotal(s.getKor() + s.getEng() + s.getMath());
//			s.setAvg(s.getTotal() / 3.0);
			list.add(s);
		}
		
//		출력
		System.out.println("========================================================");
		System.out.println("                      성적표");
		System.out.println("========================================================");
		System.out.println("[번호]\t[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		
		for(Student s : list) {
//			System.out.printf("%5d\t%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n", 
//					s.getNo(), s.getName(), s.getKor(), s.getEng(), s.getMath(), 
//					s.getKor() + s.getEng() + s.getMath(), 
//					(s.getKor() + s.getEng() + s.getMath()) / 3.0);
			System.out.printf("%5d\t%s\t%5d\t%5d\t%5d\t%5d\t%5.1f\n", 
					s.getNo(), s.getName(), s.getKor(), s.getEng(), s.getMath(), 
					s.getTotal(),
					s.getAvg());
		}
	}

	private static void m5() {
//		객체 배열
//		Cup[] list = new Cup[5];
		ArrayList<Cup> list = new ArrayList<Cup>();
		
		Cup c1 = new Cup("white", 5000);
		list.add(c1);
		list.add(new Cup("blue", 3000));
		list.add(new Cup("yellow", 7000));
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Cup c: list) {
			System.out.println(c);
		}
		
		System.out.println(list);
	}

	private static void m4() {
//		제어문 > 반복문
//		1. for문
//		2. 향상된 for문 > 배열 or 컬렉션
		
		int[] nums = { 100, 200, 300, 400, 500 };
		
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
		System.out.println();
		
//		for(요소 : 집합) {
		for(int num : nums) {
			System.out.println(num);
		}
		System.out.println();
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("강아지");
		names.add("고양이");
		names.add("코뿔소");
		
		for(String name : names) {
			System.out.println(name);
		}
		
//		배열 덤프
		System.out.println(Arrays.toString(nums));
		System.out.println(names.toString());
	}

	private static void m3() {
		int[]		ns1 = new int[3];
		ArrayList<Integer> ms1 = new ArrayList<Integer>(); 
		
		int[][]		ns2 = new int[3][4];
		ArrayList<ArrayList<Integer>> ms2 = new ArrayList<ArrayList<Integer>>();
		
		int[][][]	ns3 = new int[3][4][5];
		ArrayList<ArrayList<ArrayList<Integer>>> ms3 = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
	}

	private static void m2() {
//		String[] list;
		ArrayList<String> list = new ArrayList<>();
		
//		1. 요소 추가하기
//		- boolean add(T value)
//		- 배열의 마지막에 추가하기 > Append Mode
		list.add("바나나");
		list.add("사과");
		list.add("딸기");
		list.add("파인애플");
		list.add("귤");
		
//		2. 요소 개수
//		- int size
		System.out.println(list.size());
		
//		3. 요소 읽기
//		- T get(int index)
		System.out.println(list.get(2));
//		System.out.println(list.get(5));	//IndexOutOfBoundsException
		
//		4. 요소 수정
//		- T set(int index, T newValue);
		list.set(2, "참외");
		System.out.println(list.get(2));
		
//		5. 요소 삭제
//		- 방 없애기
//		- T remove(int index) > 방번호로 삭제
//		- boolean remove(T value) > 값으로 삭제
//		- 삭제된 방 이후 ~ 모든 요소의 방번호 - 1 > Left Shift 발생
		list.remove(2);	// 유일O
		list.remove("참외");	//유일X > 조심;;
		System.out.println(list.size());
		System.out.println(list.get(3));
		
//		6. 요소 추가
//		- 원하는 위치에 추가
//		- 삽입 모드(Insert Mode) > 새치기
//		- void add(int index, T value);
//		- 삽입된 방 이후 모든 요소 > 방번호 + 1
//		- Right Shirt 발생
		list.add(1, "망고");
		System.out.println(list.get(1));	//망고
		System.out.println(list.get(2));	//사과
		
//		7. 요소 검색
//		- int indexOf(T value)
//		- int lastIndexOf(T value)
//		- boolean contains(T value)
		System.out.println(list.indexOf("사과"));
		System.out.println(list.indexOf("키위"));
		
//		8. 요소 탐색
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
//		9. 초기화
//		- 모든 요소 삭제 > 모든방.remove()
//		- void clear();
		list.clear();
		System.out.println(list.size());
		
//		10. 빈배열 확인
//		- boolean isEmpty()
		System.out.println(list.size() == 0);
		System.out.println(list.isEmpty());
		
		list.add("사과");
		System.out.println(list.size() == 0);
		System.out.println(list.isEmpty());
		
		
	}

	private static void m1() {
//		배열
//		- 타입 명시(int)
//		- 길이 명시(3)
		int[] nums1 = new int[3];
		
//		요소 접근 > 첨자(index) 사용
		nums1[0] = 10;	//배열명[index] > 표기법 > 인덱서(Indexer)
		nums1[1] = 20;
		nums1[2] = 30;
		
		System.out.println(nums1[0]);
		System.out.println(nums1[1]);
		System.out.println(nums1[2]);
		
		System.out.println(nums1.length);
		System.out.println();
		
//		컬렉션
//		- 타입 명시(X) > Object[] > 제네릭 타입 명시
//		- 길이 명시(X) > 가변
//		ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
//		제네릭 타입을 적어주지 않으면 경고가 뜸
		
//		구버전
//		ArrayList nums2 = new ArrayList();
		
//		신버전(2014년? 이후)
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
//		요소 접근
//		nums2[0] = 100;
		nums2.add(100);	//nums2[0] = 100;
		nums2.add(200);
		nums2.add(300);
		
		System.out.println(nums2.get(0));	//nums2[0]
		System.out.println(nums2.get(1));	//nums2[1]
		System.out.println(nums2.get(2));	//nums2[2]
		
		System.out.println(nums2.size());
		
		for(int i=0; i<nums2.size(); i++) {
			System.out.println(nums2.get(i));
		}
	}
}

class Cup {
	private String color;
	private int price;
	
	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.color + ":" + this.price;
	}
}

class Student {
	private int no;			//번호
	private String name;	//이름
	private int kor;		//국어
	private int eng;		//영어
	private int math;		//수학
	
//	계산된 필드 
//	> 기존 필드를 이용해서 만들어진 필드 
//	> 보통 전역 변수로 만들지 않고 함수로 불러옴
//	private int total;		//총점
//	private double avg;		//평균
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getTotal() {
		return this.kor + this.eng + this.math;
	}
	public double getAvg() {
		return (this.kor + this.eng + this.math) / 3.0;
	}
}
