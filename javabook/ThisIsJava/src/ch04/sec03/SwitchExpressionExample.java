package ch04.sec03;

public class SwitchExpressionExample {
	public static void main(String[] args) {
//		Java12 부터 switch문에 Expression(표현식) 사용가능
//		- break문 대신 화살표와 중괄호를 사용하여 가동성 up
		char grade = 'B';
		
		switch(grade) {
			case 'A', 'a' -> {
				System.out.println("우수 회원입니다.");
			}
			case 'B', 'b' -> {
				System.out.println("일반 회원입니다.");
			}
			default -> {
				System.out.println("손님입니다.");
			}
		}
		
		switch(grade) {
			case 'A', 'a' -> System.out.println("우수 회원입니다.");
			case 'B', 'b' -> System.out.println("일반 회원입니다.");
			default -> System.out.println("손님입니다.");
		}
		/*
		일반 회원입니다.
		일반 회원입니다.
		 */
	}
}
