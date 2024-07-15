package com.lesson.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex51_Stack {

	public static void main(String[] args) {

		//Ex51_Stack.java
		/*

			List 계열
			- ArrayList
			- Stack
			- Queue


			Stack
			- 후입선출
			- LIFO, Last input First output
			- 저장소에 나중에 들어간 요소가 먼저 나온다.
			ex) 메모리 구조(Stack)
			ex) 되돌리기(Ctrl+Z), 다시하기(Ctrl+Y)
			ex) 브라우저 > 뒤로가기, 앞으로가기

			Queue
			- 선입선출
			- FIFO, First input First output
			- 저장소에 먼저 들어간 요소가 먼저 나온다.
			ex) 줄서기
			ex) 주문리스트
			ex) 순서가 있는 목록~

		*/


		//m1();
		m2();

	}//main

	private static void m2() {

		//Queue
		Queue<String> queue = new LinkedList();

		//1. 요소 추가하기
		//- boolean add(T Value)
		queue.add("빨강"); //enqueue()
		queue.add("노랑");
		queue.add("파랑");

		//2. 요소 개수
		System.out.println(queue.size());

		//3. 요소 읽기
//		System.out.println(queue.poll()); //dequeue()
//		System.out.println(queue.size());
//
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//
//		System.out.println(queue.poll());
//		System.out.println(queue.size());
//
//		System.out.println(queue.poll());


//		while (queue.size() >0) {
//			System.out.println(queue.poll());
//		}

		System.out.println(queue.peek());
		System.out.println(queue.size());

	}

	private static void m1() {

		//Stack
		Stack<String> stack = new Stack<String>();

		//1. 요소 추가하기
		//- T push(T value)
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");

		//2. 요소 개수
		System.out.println(stack.size());

		//3. 요소 읽기
		//- T pop()
		//System.out.println(stack.pop()); //읽기 + 삭제
		//System.out.println(stack.size());

		//System.out.println(stack.pop());
		//System.out.println(stack.size());

		//System.out.println(stack.pop());
		//System.out.println(stack.size());

		//System.out.println(stack.pop());


//		for (int i=0; i<stack.size(); i++) {
//			System.out.println(stack.pop());
//		}

//		while (stack.size() > 0) {
//			System.out.println(stack.pop());
//		}

		//System.out.println(stack.isEmpty());

//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}



		//요소 읽기
		//- T peek()
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());

	}

}//class













