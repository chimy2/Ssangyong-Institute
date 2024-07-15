package com.lesson.java.lambda;

import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class Ex64_Lambda {
	
	public static void main(String[] args) {
		
		//Ex64_Lambda.java
		/*
		
			람다식 > 익명 객체의 추상 메서드 > 인터페이스 참조 변수에 저장
			- 람다식을 사용하려면 결국 인터페이스가 필요하다!!
			
			함수형 인터페이스(Functional Interface)
			- 평범한 인터페이스
			- 추상 메서드 1개 소유
			- 목적 > 람다식을 저장하기 위한 인터페이스
			
			1. 표준 API 함수형 인터페이스 > JDK 제공
			2. 사용자 정의 함수형 인터페이스 > 개발자가 직접 선언(Ex63)
		
		
			표준 API 함수형 인터페이스
			1. Consumer
				- Consumer<T>
				- BiConsumer<T,U>
				- ..
				- 매개변수O, 반환값X > 추상 메서드를 제공한다.
			
			2. Supplier
				- Supplier<T>
				- ..
				- 매개변수X, 반환값O > 추상 메서드를 제공한다.
			
			3. Function
				- Function<T,R>
				- BiFunction<T,U,R>
				- ..
				- 매개변수O, 반환값O > 추상 메서드를 제공한다.
			
			4. Operator
				- Function 하위셋
				- UnaryOperator<T>
				- BinaryOperator<T>
				- ..
				- 매개변수O, 반환값O > 추상 메서드를 제공한다.
			
			5. Predicate
				- Function 하위셋
				- Predicate<T>
				- BiPredicate<T,U>
				- ..
				- 매개변수O, 반환값O > 추상 메서드를 제공한다.
		
		
		*/
		
		//m1();
		m2();
		
	}

	private static void m2() {
		
		//Supplier
		//- 매개변수없이 반환값을 돌려주는 업무를 구현하는 인터페이스
		//- getXXX() 추상 메서드 제공
		
		Supplier<Integer> s1 = () -> { return 100; };
		Supplier<Integer> s2 = () -> 100;
		
		System.out.println(s1.get());
		
		Supplier<String> s3 = () -> "홍길동";
		System.out.println(s3.get());
		
		Supplier<Integer> s4 = () -> {
			Calendar now = Calendar.getInstance();
			return now.get(Calendar.HOUR_OF_DAY);
		};
		System.out.println(s4.get());
		
		
		BooleanSupplier s5 = () -> true;
		System.out.println(s5.getAsBoolean());
		
	}

	private static void m1() {

		//Consumer
		//- 매개변수를 받아서 소비하는 업무를 구현하는 인터페이스
		//- acceptXXX() 추상 메서드 제공
		
		MyConsumer m1 = num -> System.out.println(num);
		m1.test(100);
		m1.test(200);
		
		
		//java.util.function
		Consumer<Integer> c1 = num -> System.out.println(num);
		c1.accept(100);
		c1.accept(200);
		
		Consumer<Integer> c2 = num -> System.out.println(num * num);
		c2.accept(5);
		
		Consumer<String> c3 = str -> System.out.println(str.length());
		c3.accept("홍길동");
		
		Consumer<Integer> c4 = count -> {
			
			for (int i=0; i<count; i++) {
				System.out.println(i);
			}
			System.out.println();
			
		};
		c4.accept(10);
		
		Consumer<Member> c5 = m -> {
			System.out.println(m.getName());
			System.out.println(m.getAge());
		};
		c5.accept(new Member("홍길동", 20));
		
		
		BiConsumer<String, Integer> bc1 = (name, age) -> {
			System.out.println(name + "," + age);
		};
		bc1.accept("아무개", 22);
		
		BiConsumer<Integer, Integer> bc2 = (a, b) -> System.out.println(a + b);
		bc2.accept(100, 200);
		
		
		//Consumer<Integer> ic1;
		IntConsumer ic1 = num -> System.out.println(num);
		ic1.accept(100);
		
		
	}

}

class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

//람다식을 저장하기 위해서 선언한 인터페이스
@FunctionalInterface
interface MyConsumer {
	void test(int num);
}












