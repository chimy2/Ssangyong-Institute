package com.test.question.collection;

public class Q105 {
//	컬렉션: MyQueue
	public static void main(String[] args) {
//		요구사항] MyQueue 클래스를 구현하시오.
//			- MyQueue
//				- Queue 사용자 정의 클래스
//				- 행동
//					- boolean add(String value)
//						- 값을 순차적으로 추가한다.
//						- value: 추가할 요소의 값
//						- return: 성공 유무
//					- String poll()
//						- 값을 순차적으로 가져온다.
//						- return: 가져올 요소의 값
//					- int size()
//						- 요소의 개수를 반환한다.
//						- return: 요소의 개수
//					- String peek()
//						- 이번에 가져올 값을 확인한다.
//						- value: 값 반환
//					- void clear()
//						- 배열의 모든 요소를 삭제한다.
//					- void trimToSize()
//						- 배열안의 요소의 개수만큼 배열의 길이를 줄인다.
		/*
		호출------------------------------------------------
		//배열 생성
		MyQueue queue = new MyQueue();
		
		//추가
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		queue.add("주황");
		queue.add("검정");
		
		//읽기
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		//개수
		System.out.println(queue.size());
		
		//확인
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		//크기 조절
		queue.trimToSize();
		
		//초기화
		queue.clear();
		System.out.println(queue.size());
		
		출력------------------------------------------------
		빨강 //System.out.println(queue.poll());
		노랑 //System.out.println(queue.poll());
		파랑 //System.out.println(queue.poll());
		
		2 //System.out.println(queue.size());
		
		//확인
		주황 //System.out.println(queue.peek());
		주황 //System.out.println(queue.peek());
		2 //System.out.println(queue.size());
		
		0 //초기화
		 */
		//배열 생성
		MyQueue queue = new MyQueue();
		
		//추가
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		queue.add("주황");
		queue.add("검정");
		
		//읽기
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		//개수
		System.out.println(queue.size());
		
		//확인
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		//크기 조절
		queue.trimToSize();
		
		//초기화
		queue.clear();
		System.out.println(queue.size());
	}
}
