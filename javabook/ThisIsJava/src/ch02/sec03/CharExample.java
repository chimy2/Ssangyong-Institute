package ch02.sec03;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 'A';	//문자 저장
		char c2 = 65;	//유니코드 직접 저장
		
		char c3 = '가';		//문자 저장
		char c4 = 44032;	//유니코드 직접 저장
//		char c5 = '';
//		char 타입 변수는 초기화 시 반드시 한 문자를 포함하여야 한다
//		> 공백으로 초기화 불가능
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		/*
		A
		A
		가
		가
		 */
	}
}
