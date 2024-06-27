package ch06.sec10.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
//		static으로 선언한 정적 멤버라서 객체 생성없이 클래스에서 바로 접근 가능
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		
//		인스턴스 멤버는 객체를 생성해서 접근해야 하는데
//		그럴 필요 없는 정적 멤버를 객체를 생성해서 접근하면
//		이클립스에서 경고메세지를 출력한다
		Calculator c=new Calculator();
//		The static field Calculator.pi should be accessed in a static way
		System.out.println(c.pi);
		/*
		result1 : 314.159
		result2 : 15
		result3 : 5
		*/
	}
}
