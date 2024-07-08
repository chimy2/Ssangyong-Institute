package ch16.sec05.exam02;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		person.ordering(String::compareToIgnoreCase);
//		홍길동은 김길동보다 뒤에 옵니다.
	}
}
