package ch07.sec11;

//Java15 부터 무분별한 자식 클래스 생성을 방지하기 위해 sealed 클래스가 추가되었다
//- permits 키워드 뒤에 상속 가능한 자식 클래스를 지정해야한다
//- sealed class를 상속 받으면 자식 class는 아래 3가지 키워드 중 하나로 선언해야한다
//1. final(더이상 상속하지 못함 > 자식 클래스만 될 수 잇음)나
//2. non-sealed(봉인을 해제 > 자식 클래스를만들 수 있음)
//3. sealed(또 다른 봉인 클래스로 선언)
//public sealed class Person permits Employee, Manager {
public class Person {
//	필드
	public String name;
	
//	메소드
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}
