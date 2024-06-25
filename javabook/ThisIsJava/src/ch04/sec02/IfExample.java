package ch04.sec02;

public class IfExample {
	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다");
		}
		
		if(score < 90)	//괄호를 생략하면 범위가 모호해져 실수할 가능성이 높다
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		/*
		점수가 90보다 큽니다.
		등급은 A입니다
		등급은 B입니다.
		 */
	}
}
