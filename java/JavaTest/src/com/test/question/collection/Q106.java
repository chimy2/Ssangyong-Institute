package com.test.question.collection;

public class Q106 {
//	컬렉션: MyStack
	public static void main(String[] args) {
//		요구사항] MyStack 클래스를 구현하시오.
//			- MyStack
//				- Stack 사용자 정의 클래스
//				- 행동
//					- boolean push(String value)
//						- 값을 순차적으로 추가한다.
//						- value: 추가할 요소의 값
//						- return: 성공 유무
//					- String pop()
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
		호출.................................................................
		//배열 생성
		MyStack stack = new MyStack();
		
		//추가
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		stack.push("검정");
		
		//읽기
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//개수
		System.out.println(stack.size());
		
		//확인
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		//크기 조절
		stack.trimToSize();
		
		//초기화
		stack.clear();
		System.out.println(stack.size());
		
		출력.................................................................
		검정 //System.out.println(stack.pop());
		주황 //System.out.println(stack.pop());
		파랑 //System.out.println(stack.pop());
		
		2 //System.out.println(stack.size());
		
		//확인
		노랑 //System.out.println(stack.peek());
		노랑 //System.out.println(stack.peek());
		2 //System.out.println(stack.size());
		
		0 //초기화

		 */
		//배열 생성
		MyStack stack = new MyStack();
		
		//추가
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		stack.push("검정");
		
		//읽기
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		//개수
		System.out.println(stack.size());
		
		//확인
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		//크기 조절
		stack.trimToSize();
		
		//초기화
		stack.clear();
		System.out.println(stack.size());
	}
}
