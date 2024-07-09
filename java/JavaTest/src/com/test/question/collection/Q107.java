package com.test.question.collection;

public class Q107 {
//	컬렉션: MyHashMap
	public static void main(String[] args) {
//		요구사항] MyHashMap 클래스를 구현하시오.
//			- MyHashMap
//				- HashMap 사용자 정의 클래스
//				- 행동
//					- String put(String key, String value)
//						- 키와 값을 요소로 추가한다.
//						- key: 추가할 요소의 키
//						- value: 추가할 요소의 값
//						- return: null
//					- String get(String key)
//						- 키에 대응하는 요소의 값을 가져온다.
//						- key: 가져올 요소의 키
//						- return: 가져올 요소의 값
//					- int size()
//						- 요소의 개수를 반환한다.
//						- return: 요소의 개수
//					- String put(String key, String value)
//						- 해당키의 값을 요소로 수정한다.
//						- key: 수정할 요소의 키
//						- value: 수정할 요소의 값
//						- return: 수정하기 전 요소의 값
//					- String remove(String key)
//						- 원하는 키의 요소를 삭제한다.
//						- key: 삭제할 요소의 키
//						- return: 삭제된 요소의 값
//					- boolean containKey(String key)
//						- 해당 키가 존재하는지 확인한다.
//						- key: 확인할 키
//						- return: 키의 존재 유무
//					- boolean containsValue(String value)
//						- 해당 값이 존재하는지 확인한다.
//						- value: 확인할 값
//						- return: 값의 존재 유무
//					- void clear()
//						- 배열의 모든 요소를 삭제한다.
//					- void trimToSize()
//						- 배열안의 요소의 개수만큼 배열의 길이를 줄인다.
		/*
		호출-------------------------------------------------------------------
		//배열 생성
		MyHashMap map = new MyHashMap();
		
		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		
		//읽기
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		//개수
		System.out.println(map.size());
		
		//수정
		map.put("영어", "합격");
		System.out.println(map.get("영어"));
		
		//삭제
		map.remove("영어");
		System.out.println(map.get("영어"));
		
		//검색(key)
		if (map.containsKey("국어")) {
		      System.out.println("국어 점수 있음");
		} else {
		      System.out.println("국어 점수 없음");
		}
		
		//검색(value)
		if (map.containsValue("합격")) {
		      System.out.println("합격 과목 있음");
		} else {
		      System.out.println("합격 과목 없음");
		}
		
		//초기화
		map.clear();
		System.out.println(map.size());
		
		출력-------------------------------------------------------------------
		합격 //System.out.println(map.get("국어"));
		불합격 //System.out.println(map.get("영어"));
		보류 //System.out.println(map.get("수학"));
		
		3 //System.out.println(map.size());
		
		//수정
		합격 //System.out.println(map.get("영어"));
		
		//삭제
		null //System.out.println(map.get("영어"));
		
		//검색(key)
		국어 점수 있음 
		
		//검색(value)
		합격 과목 있음 
		
		0 //초기화

		 */
		//배열 생성
		MyHashMap map = new MyHashMap();
		
		//추가
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류");
		
		//읽기
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		//개수
		System.out.println(map.size());
		
		//수정
		map.put("영어", "합격");
		System.out.println(map.get("영어"));
		
		//삭제
		map.remove("영어");
		System.out.println(map.get("영어"));
		
		//검색(key)
		if (map.containsKey("국어")) {
		      System.out.println("국어 점수 있음");
		} else {
		      System.out.println("국어 점수 없음");
		}
		
		//검색(value)
		if (map.containsValue("합격")) {
		      System.out.println("합격 과목 있음");
		} else {
		      System.out.println("합격 과목 없음");
		}
		
		//초기화
		map.clear();
		System.out.println(map.size());
	}
}
