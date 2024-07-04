package ch12.sec03.exam04;

//Java14부터 DTO를 작성할 때 반복적으로 사용되는 코드를 줄이기 위한 Record 도입
public record Member(String id, String name, int age) {

}
