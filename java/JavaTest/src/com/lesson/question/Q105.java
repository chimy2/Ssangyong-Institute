package com.test.question;

public class Q105 {
	
	public static void main(String[] args) {
	
		//Queue
		MyQueue queue = new MyQueue();
		
		System.out.println(queue);
		
		//요소 추가
		queue.add("빨강");
		System.out.println(queue);
		
		queue.add("노랑");
		System.out.println(queue);
		
		queue.add("주황");
		System.out.println(queue);
		
		queue.add("초록");
		System.out.println(queue);
		
		queue.add("파랑");
		System.out.println(queue);
		
		
		System.out.println(queue.size());
		
		
		//요소 읽기(+삭제)
		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println(queue.size());
		
		queue.add("남색");
		System.out.println(queue);
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue);
		
		
		queue.clear();
		System.out.println(queue);
		
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		
		
		queue.add("빨강");
		queue.add("노랑");
		queue.add("파랑");
		System.out.println(queue);
		
		queue.trimToSize();
		
		System.out.println(queue);
		
		queue.add("주황");
		System.out.println(queue);
		
		
		
//		MyQueue queue2 = new MyQueue(100);
//		
//		//4 > 8 > 16 > 32 > 64 > 128
//		for (int i=0; i<100; i++) {
//			queue2.add("" + i);
//		}
//		
//		System.out.println(queue2.size());
//		
//		System.out.println(queue2);
		
		
	}

}


























