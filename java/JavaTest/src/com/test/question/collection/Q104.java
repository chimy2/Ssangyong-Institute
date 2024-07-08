package com.test.question.collection;

public class Q104 {
//	컬렉션: MyArrayList
	public static void main(String[] args) {
//		요구사항] MyArrayList 클래스를 구현하시오.
//			- MyArrayList
//				- ArrayList 사용자 정의 클래스
//				- 행동
//					- boolean add(String value)
//						- Append 모드로 배열의 맨 끝에 요소를 추가한다.
//						- value: 추가할 요소
//						- return: 성공 유무
//					- String get(int index)
//						- 원하는 위치에 있는 요소를 가져온다.
//						- index: 가져올 요소의 위치
//						- return: 가져올 요소의 값
//					- int size()
//						- 요소의 개수를 반환한다.
//						- return: 요소의 개수
//					- String set(int index, String value)
//						- 원하는 위치의 요소를 다른 값으로 수정한다.
//						- index: 수정할 요소의 위치
//						- value: 수정할 요소의 값
//						- return: 수정하기 전 요소의 값
//					- String remove(int index)
//						- 원하는 위치의 요소를 삭제한다.
//						- index: 삭제할 요소의 위치
//						- return: 삭제된 요소의 값
//					- boolean add(int index, String value)
//						- Insert 모드로 원하는 위치에 요소를 삽입한다.
//						- index: 수정할 요소의 위치
//						- value: 수정할 요소의 값
//						- return: 성공 유무
//					- int indexOf(String value)
//						- 원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다.
//						- value: 검색할 요소의 값
//						- return: 검색된 요소의 위치
//					- int lastIndexOf(String value)
//						- 원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다.
//						- value: 검색할 요소의 값
//						- return: 검색된 요소의 위치
//					- void clear()
//						- 배열의 모든 요소를 삭제한다.
//					- void trimToSize()
//						- 배열안의 요소의 개수만큼 배열의 길이를 줄인다.
		
		/*
		호출-----------------------------------------------------------
		//배열 생성
		MyArrayList list = new MyArrayList();
		
		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");
		
		//읽기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		//개수
		System.out.println(list.size());
		
		//탐색 + 읽기
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//수정
		list.set(0, "우하하");
		System.out.println(list.get(0));
		
		//삭제
		list.remove(1);
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//삽입
		list.add(1, "호호호");
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//검색
		if (list.indexOf("홍길동") > -1) {
		      System.out.println("홍길동 있음");
		} else {
		      System.out.println("홍길동 없음");
		}
		
		//초기화
		list.clear();
		System.out.println(list.size());
		
		출력-----------------------------------------------------------
		홍길동 //System.out.println(list.get(0));
		아무개 //System.out.println(list.get(1));
		하하하 //System.out.println(list.get(2));
		3 //System.out.println(list.size());
		
		//탐색 + 읽기
		홍길동 
		아무개 
		하하하 
		
		우하하 //list.set(0, "우하하");
		
		//삭제
		우하하 
		하하하 
		
		//삽입
		우하하 
		호호호 
		하하하 
		
		홍길동 없음 //검색
		0 //초기화
		 */
		
		//배열 생성
		MyArrayList list = new MyArrayList();
		
		//추가
		list.add("홍길동");
		list.add("아무개");
		list.add("하하하");
		
		//읽기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		//개수
		System.out.println(list.size());
		
		//탐색 + 읽기
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//수정
		list.set(0, "우하하");
		System.out.println(list.get(0));
		
		//삭제
		list.remove(1);
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//삽입
		list.add(1, "호호호");
		for (int i=0; i<list.size(); i++) {
		      System.out.println(list.get(i));
		}
		
		//검색
		if (list.indexOf("홍길동") > -1) {
		      System.out.println("홍길동 있음");
		} else {
		      System.out.println("홍길동 없음");
		}
		
		//초기화
		list.clear();
		System.out.println(list.size());
	}
}
