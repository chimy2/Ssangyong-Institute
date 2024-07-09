package com.test.question.collection;

public class Q108 {
//	컬렉션: MySet
	public static void main(String[] args) {
//		요구사항] MySet 클래스를 구현하시오.
//			- MySet
//				- MySet 사용자 정의 클래스
//				- 행동
//					- boolean add(String value)
//						- 배열에 요소를 추가한다.
//						- value: 추가할 요소
//						- return: 성공 유무
//					- int size()
//						- 요소의 개수를 반환한다.
//						- return: 요소의 개수
//					- boolean remove(String value)
//						- 배열의 요소를 삭제한다.
//						- s: 삭제할 요소
//						- return: 성공 유무
//					- void clear()
//						- 배열의 모든 요소를 삭제한다.
//					- boolean hasNext()
//						- 다음 요소가 있는지 확인한다.
//						- return: 존재 유무
//					- String next()
//						- 다음 요소를 반환한다.
//						- return: 다음 요소
		/*
		호출--------------------------------------------------------------------
		//배열 생성
		MySet list = new MySet();

		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");

		//개수
		System.out.println(list.size());

		//삭제
		list.remove("아무개");

		//개수
		System.out.println(list.size());

		//탐색 + 읽기
		while (list.hasNext()) {
		      System.out.println(list.next());
		}

		//초기화
		list.clear();
		System.out.println(list.size());
		
		출력--------------------------------------------------------------------
		3 //System.out.println(list.size());

		//삭제
		2

		//탐색 + 읽기
		홍길동 
		하하하 

		0 //초기화
		*/
		//배열 생성
		MySet list = new MySet();

		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");

		//개수
		System.out.println(list.size());

		//삭제
		list.remove("아무개");

		//개수
		System.out.println(list.size());

		//탐색 + 읽기
		while (list.hasNext()) {
		      System.out.println(list.next());
		}

		//초기화
		list.clear();
		System.out.println(list.size());
	}
}
