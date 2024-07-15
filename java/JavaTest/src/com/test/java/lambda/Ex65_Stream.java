package com.test.java.lambda;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import com.test.data.Data;
import com.test.data.Item;
import com.test.data.User;

public class Ex65_Stream {
	public static void main(String[] args) {
		/*
		 * 자바 스트림
		 * 1. 입출력 스트림
		 * - 파일 입출력, 콘솔 입출력, 네트워크 입출력 등..
		 * 
		 * 2. 스트림
		 * - Java 8(JDK 1.8) + 람다식과 같이 출시
		 * - 배열(컬렉션)의 탐색(조작) 기술(🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟)
		 * - 파일 입출력 지원
		 * - 디렉토리 탐색 지원
		 * - 기타 등등..
		 * 
		 * 표준 API 함수형 인터페이스
		 * 1. Consumer
		 * - (매개변수) -> {}
		 * 
		 * 2. Supplier
		 * - () -> { return 값; }
		 * 
		 * 3. Function
		 * - (매개변수) -> { return 값; }
		 * 
		 * 4. Operator
		 * - (매개변수) -> { return 값; }
		 * - 매개변수와 반환값이 동일한 자료형을 가진다.
		 * 
		 * 5. Predicate
		 * - (매개변수) -> { return 값; }
		 * - 반환값이 항상 Boolean이다.
		 */
		
		/*
		 * Java 1.0
		 * - 1996년
		 * 
		 * 1.2 > Java 2
		 * 1.3 > Java 3
		 * 1.4 > Java 4
		 * 1.5 > Java 5
		 * 1.8 > Java 8 > Oracle 첫버전 + 기능 추가(2014년)
		 * 1.22 > Java 22
		 * 
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
		m10();
	}

	private static void m10() {
//		매칭
//		- allMatch(), anyMatch(), noneMatch()
//		- filter와는 전혀 다름
//		- 최종 파이프
//		- boolean allMatch(Predicate) : 모든 요소가 조건을 모두 만족하는지?
//		- boolean anyMatch(Predicate) : 일부 요소가 조건을 만족하는지?
//		- boolean noneMatch(Predicate) : 모든 요소가 조건을 모두 불만족하는지?
		
		int[] nums = { 2, 4, 6, 8, 10 };
		
//		요구사항] 배열에 짝수만 있는가?
		boolean result = false;
		
		for(int n : nums) {
			if(n % 2 != 0) {
				result = true;
				break;
			}
		}
		
		if(!result) {
			System.out.println("짝수만 존재");
		} else {
			System.out.println("홀수가 존재");
		}
		
//		조건 && 조건 && 조건
		result = Arrays.stream(nums).allMatch(n -> n % 2 == 0);
		
		System.out.println(result);
		
		nums = new int[] { 2, 4, 6, 8, 10, 3 };
		
//		nums안에 홀수가 1개라도 들어있는지?
//		조건 || 조건 || 조건
		result = Arrays.stream(nums).anyMatch(n -> n % 2 == 1);
		
		System.out.println(result);
		
		nums = new int[] { 2, 4, 6, 8, 10 };
		
//		nums안에 홀수가 없니?
		result = Arrays.stream(nums).noneMatch(n -> n % 2 == 1);
		System.out.println(result);
		
		System.out.println(
				Data.getUserList().stream()
									.anyMatch(user -> user.getHeight() >= 180)
				);
		
		
	}

	private static void m9() {
//		집계/통계, Reduce
//		- count()
//		- max()
//		- min()
//		- sum()
//		- avg()
//		- 최종 파이프
//		- 앞의 스트림 요소를 취합해서 하나의 통곗값을 생성
		
		long count = Data.getIntList().stream().count();
		System.out.println(count);
		
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 1).count());
		System.out.println(Data.getUserList().stream().filter(user -> user.getGender() == 2).count());
		
//		max(), min()
		List<Integer> nums = Data.getIntList();
		
		int max = -1;	//최댓값 > 가장 작은 수 or 가장 작은수 - 1
		int min = 101;	//최솟값 > 가장 큰 수 or 가장 큰 수 + 1
		
		for(int n : nums) {
			if(n > max) {
				max = n;
			} if(n < min) {
				min = n;
			}
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(nums.stream().max((a, b) -> a - b));
		
//		Optional<Integer>
//		- int or Integer 타입과 거의 동일한 자료형
//		- null을 가질 수 있는 int
//		nums.clear();
		Optional<Integer> result = nums.stream().max((a, b) -> a - b);
		System.out.println(result.get());
		
		result = nums.stream().min((a, b) -> a - b);
		System.out.println(result.get());
		
//		값형 변수는 null을 가질 수 없다.(null은 참조형만 가능)
//		int a = null;
		
		/*
		Integer n1 = null;	// = nums.stream().max((a, b) -> a - b);
		Optional<Integer> n2 = nums.stream().max((a, b) -> a - b);
		
		if(n1 != null) {
			System.out.println(n1);
		}
		System.out.println(n2.isEmpty());
		*/
//		Optional은 NullPointerException에 안전한 자료형이다.
		
		Optional<User> user1 = Data.getUserList().stream().max((u1, u2) -> u1.getHeight() - u2.getHeight());
		System.out.println(user1.get());
		
		Optional<User> user2 = Data.getUserList().stream().min((u1, u2) -> u1.getHeight() - u2.getHeight());
		System.out.println(user2.get());
		
//		count(), max(), min() > 모든 자료형(Stream<T>)에 적용 가능
		
//		sum(), avg() > intStream > 숫자에 적용 가능
		
//		Stream<Integer> 변환 IntStream
		System.out.println(nums.stream().mapToInt(i -> i).sum());
		System.out.println();
		
		System.out.println(nums.stream().mapToInt(n -> n).average().getAsDouble());
		System.out.println();
		
//		남자 평균 키?
		System.out.println(
				Data.getUserList().stream()
									.filter(user -> user.getGender() == 1)
									.mapToInt(user -> user.getHeight())
									.average().getAsDouble()
				);
		
	}

	private static void m8() {
//		정렬
//		- sorted(Comparator) 
//		- 중간 파이프
//		- 용법이 기존 컬렉션의 sort() 메서드와 동일
		
		Data.getIntList().stream()
//							.sorted()
							.sorted((a, b) -> b - a)
							.forEach(n -> System.out.println(n));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(3);
		
		System.out.println(list);
		
		list.sort((a, b) -> a - b);
		System.out.println(list);
		
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
		
		list.sort((a, b) -> b - a);
		System.out.println(list);
		
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
		Data.getIntList().stream()
							.sorted(Comparator.reverseOrder())
							.forEach(n -> System.out.println(n));
		System.out.println();
		
		Data.getIntList().stream()
							.distinct()
							.filter(n -> n % 2 == 0)
							.sorted()
							.forEach(n -> System.out.println(n));
	}

	private static void m7() {
//		변환
//		- map(Function), mapXXX(Function)
//		- 중간 파이프
//		- 앞의 스트림의 요소를 다른 형태의 스트림으로 반환한다.
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
//		긴단어, 짧은 단어
//		list.stream()
//			.forEach(word -> System.out.println(word));
//		System.out.println();
		
		list.stream()
			.forEach(word -> {
				if(word.length() >= 5) {
					System.out.println("긴단어");
				} else {
					System.out.println("짧은단어");
				}
			});
		System.out.println();
		
		list.stream()
			.map(word -> word.length() >= 5 ? "긴단어":"짧은단어")
			.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
							.forEach(user -> System.out.println(user.getName()));
		System.out.println();
		
		Data.getUserList().stream()
//							.map(user -> user.getName())	//User > String
//							.map(user -> user.getAge())		//User > Integer
							.map(user -> user.getGender() == 1 ? "남자" : "여자")
//							.forEach(name -> System.out.println(name));
//							.forEach(age -> System.out.println(age));
							.forEach(gender -> System.out.println(gender));
		System.out.println();
		
//		names > Member 객체 변환
		String[] names = { "홍길동", "아무개", "강아지", "고양이", "병아리" };
		
//		new Mamber(names[0], 20)
//		new Mamber(names[1], 20)
//		...
//		new Mamber(names[4], 20)
		Arrays.stream(names)
				.map(name -> new Member(name, 20))	//String > Member
				.forEach(member -> System.out.println(member));
		System.out.println();
		
//		User > (변환) > Member
		Data.getUserList().stream()
							.map(user -> new Member(user.getName(), user.getAge()))
							.forEach(member -> System.out.println(member));
	}

	private static void m6() {
//		중복 제거
//		- distinct()
//		- 중간 파이프
//		- 앞의 스트림에서 중복 요소를 제거한다.
//		- 유일한 요소만 다음 파이프로 전달한다.
//		- Set 역할
		
		List<Integer> list = Data.getIntList();
		System.out.println(list);
		
//		위의 집합에서 중복값을 제거하시오
//		Case 1. HashSet
		Set<Integer> set = new HashSet<Integer>();
		
		for(int n : list) {
			set.add(n);	//자동으로 중복값 제거
		}
		System.out.println(set.size());
		
//		Case 2.
		Set<Integer> set2 = new HashSet<Integer>(list);	//중복값 제거
		System.out.println(set2.size());
		
//		Case 3.
		System.out.println(list.stream().distinct().count());
		
		Data.getStringList().stream()
							.filter(word -> word.length() >= 5)
							.distinct()
							.forEach(word -> System.out.println(word));
		System.out.println();
		
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member("홍길동", 20));
		mlist.add(new Member("아무개", 22));
		mlist.add(new Member("강아지", 5));
		mlist.add(new Member("고양이", 3));
		mlist.add(new Member("홍길동", 20));	//같은 사람?
		
		mlist.stream()
			.distinct()
			.forEach(m -> System.out.println(m));
		
	}

	private static void m5() {
		Data.getStringList().stream()
							.filter(word -> word.length() >= 5)
							.filter(word -> word.startsWith("애"))
							.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
						.filter(user -> user.getGender() == 1)
						.filter(user -> user.getHeight() >= 180)
						.filter(user -> user.getWeight() >= 80)
						.forEach(user -> System.out.println(user));
		System.out.println();
	}

	private static void m4() {
		/*
		 * 스트림, Stream
		 * - 데이터 소스로부터 생성
		 * - list.stream().forEach();
		 * 
		 * 파이프, Pipe
		 * - 스트림 객체 메서드
		 * 1. 중간 파이프
		 * 	- 반환값이 스트림O
		 * 2. 최종 파이프
		 * 	- 반환값이 스트림X
		 * 
		 * 최종 정리
		 * - forEach(Consumer)
		 * - 최종 파이프
		 * - 앞의 스트림으로부터 요소를 전달받아 최종 처리하는 메서드
		 * 
		 * 필터링
		 * - filter(Predicate)
		 * - 중간 파이프
		 * - 앞의 스트림으로부터 요소를 전달받아 조건에 맞는 요소만 남기고 맞지 않는 요소는 버린다.
		 * 
		 */
		
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
//		요구사항] 짝수만 출력
//		1. for
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) % 2 == 0) {
				System.out.printf("%4d", list.get(i));
			}
		}
		System.out.println();
		
//		2. foreach
		for(int n: list) {
			if(n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		}
		System.out.println();

//		3. stream
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		list.stream()
			.filter(n -> n % 2 == 0 && n >= 50)
			.forEach(num -> System.out.printf("%4d", num));
		System.out.println();
		
		list.stream()
			.filter(n -> n % 2 == 0)
			.filter(n -> n >= 50)
			.forEach(num -> System.out.printf("%4d", num));
		System.out.println();
	}

	private static void m3() {
//		스트림을 얻어오는 방법
//		- stream() 메서드를 사용한다.
//		1. 배열로부터		> 스트림 > 사용법 동일
//		2. 컬렉션으로부터	> 스트림 > 사용법 동일
//		3. 숫자 범위			> 스트림 > 사용법 동일
//		4. 파일로부터		> 스트림 > 사용법 동일
//		5. 디렉토리로부터	> 스트림 > 사용법 동일
		
//		1. 배열
		int[] nums1 = { 10, 20, 30, 40, 50 };
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
//		2. 컬렉션
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		nums2.add(400);
		nums2.add(500);
		nums2.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		LinkedList<Integer> nums3 = new LinkedList<Integer>();
		nums3.add(100);
		nums3.add(200);
		nums3.add(300);
		nums3.add(400);
		nums3.add(500);
		nums3.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		HashSet<Integer> nums4 = new HashSet<Integer>();
		nums4.add(100);
		nums4.add(200);
		nums4.add(300);
		nums4.add(400);
		nums4.add(500);
		nums4.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
//		스트림 사용 불가능
//		HashMap<String, Integer> map = new HashMap<>();
//		map.stream()
		
//		List 계열, Set 계열 > Stream 제공
		
//		3. 숫자 범위
		IntStream.range(1, 11).forEach(num -> System.out.println(num));
		System.out.println();
		
		try {
//			4. 파일 > 스트림 > 읽기 작업
			Path path = Paths.get("dat\\score.txt");
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			
//			5. 디렉토리 > dir.listFiles()
			Path dir = Paths.get("C:\\class\\dev\\eclipse");
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName());
			});
		} catch (Exception e) {
			System.out.println("Ex65_Stream.m3");
			e.printStackTrace();
		}
		
	}

	private static void m2() {
//		배열(컬렉션) 탐색
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
//		1. for문(while문)
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%s\t", list.get(i));
		}
		System.out.println();
		
//		2. 향상된 for문 == foreach문
		for(String word : list) {
			System.out.printf("%s\t", word);
		}
		System.out.println();
		
//		3.iterator
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.printf("%s\t", iter.next());
		}
		System.out.println();
		
//		4. stream
//		4.1 list.stream() > ArrayList로부터 스트림 객체를 생성
//		4.2 스트림 사용 > 결과 > ArrayList 반영
		/*
		Stream<String> stream = list.stream();
		
		Consumer<String> c1 = str -> System.out.println(str);
		c1.accept("홍길동");
		stream.forEach(c1);	//c1.accept(가져온 단어 x 10회 호출)
		System.out.println();
		
		stream.forEach(s -> System.out.printf("%s\t", s));
		System.out.println();
		*/
		list.stream().forEach(s -> System.out.printf("%s\t", s));
		System.out.println();
		
		Data.getIntList(10).stream().forEach(num -> System.out.println(num));
		
		Data.getUserList().stream().forEach(user -> {
			System.out.println("[유저]");
			System.out.println("유저명: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println();
		});
	}

	private static void m1() {
		int[] nums1 = Data.getIntArray();
//		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = Data.getIntArray(10);
//		System.out.println(Arrays.toString(nums2));
		
		List<Integer> nums3 = Data.getIntList(10);
//		System.out.println(nums3);
		
		String[] txt1 = Data.getStringArray(10);
//		System.out.println(Arrays.toString(txt1));
		
		User[] ulist = Data.getUserArray();
		System.out.println(Arrays.toString(ulist));
		
		Item[] ilist = Data.getItemArray();
		System.out.println(Arrays.toString(ilist));
		
//		사용자 라이브러리 만들기(*.jar)
//		- 내가 만든 기능을 다른 사람에게 전달할 때 사용
//		- 배포의 단위 > *.jar
		
//		jar -> 컴파일된 파일 배포 
		
//		jar 적용 방법
//		- 프로젝트 우클릭 > Build Path > Configure Build Path.. 
//			> Libraries > classPath >  Add JARs/Exteral JARs..
		
	}
}
