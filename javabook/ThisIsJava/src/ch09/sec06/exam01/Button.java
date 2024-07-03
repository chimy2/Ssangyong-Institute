package ch09.sec06.exam01;

public class Button {
//	정적 중첩 인터페이스
//	중첩인터페이스는 암시적으로 static이므로 생략 가능
//	public static interface ClickListener {
	public interface ClickListener {
//		추상 메소드
		void onClick();
	}
}
