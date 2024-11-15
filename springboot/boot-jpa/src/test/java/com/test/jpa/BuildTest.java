package com.test.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuildTest {

	@Test
	void test() {

//		생성자를 사용한 객체 생성
//		1. 초기화를 하고 싶지 않은 멤버를 처리하기 불편
//			- null 혹은 기본값 대입 > 가독성 저하 - null이 왜들어갔는지, 코드상으로도 보기 안좋음
//			- 생성자 다양하게 오버로딩 > 개발자 비용 발생
//		2. 매개변수의 개수 or 순서 > 가독성 저하

//		Address 클래스 > 사용
		Member m1 = new Member(null, "꿀꿀이", 5, "서울시", "m");

//		Member [seq=null, name=꿀꿀이, age=5, address=서울시, gender=m]
		System.out.println(m1);

//		User 클래스 > 객체 생성
		User u1 = new User.Builder().setSeq(51L).setName("꿀꿀이").setAge(3).setAddress("서울시").setGender("m").build();

//		User [seq=51, name=꿀꿀이, age=3, address=서울시, gender=m]
		System.out.println(u1);

//		1. 초기화를 하고 싶지 않은 멤버를 처리하기 불편 
//			> 생성자로 생성하면 초기화 하고 싶지 않은 것도 초기화 해야하는데 그럴 필요가 없어짐
		
//			- null 혹은 기본값 대입 > 가독성 저하 - null이 왜들어갔는지, 코드상으로도 보기 안좋음
//				> 생성자 오버로딩을 하거나 null을 직접적으로 집어 넣지 않아도 자유조합해서 객체를 만들 수 있음
		
//			- 생성자 다양하게 오버로딩 > 개발자 비용 발생
		
//		2. 매개변수의 개수 or 순서 > 가독성 저하

		User u2 = new User.Builder().setName("꿀꿀이").setAge(5).setAddress("서울시").setGender("m").build();
		
//		User [seq=null, name=꿀꿀이, age=5, address=서울시, gender=m]
		System.out.println(u2);
		
//		
//		User u3 = new User.Builder().set
		User u3 = new User.Builder().setSeq(51L).setGender("m").build();
		
		System.out.println(u3);
		
		Guest g1 = new Guest.Builder().name("아무개").age(20).gender("f").address("서울시").build();
		
//		Guest [seq=null, name=아무개, age=20, address=서울시, gender=f]
		System.out.println(g1);
	}
}

class Guest {
	
	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	private Guest(Builder builder) {
		this.seq = builder.seq;
		this.name = builder.name;
		this.age = builder.age;
		this.address = builder.address;
		this.gender = builder.gender;
	}
	
	@Override
	public String toString() {
		return "Guest [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ "]";
	}
	
	public static class Builder {
		
		private Long seq;
		private String name;
		private Integer age;
		private String address;
		private String gender;
		
		public Builder seq(Long seq) {
			this.seq = seq;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder age(Integer age) {
			this.age = age;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder gender(String gender) {
			this.gender = gender;
			return this;
		}
		
		public Guest build() {
			return new Guest(this);
		}
	}
	
}

class User {

	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;

	private User(Builder builder) {
		this.seq = builder.seq;
		this.name = builder.name;
		this.age = builder.age;
		this.address = builder.address;
		this.gender = builder.gender;
	}

	@Override
	public String toString() {
		return "User [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ "]";
	}

	// 중첩 클래스 > Java는 중첩 클래스를 지원함
	public static class Builder {

		private Long seq;
		private String name;
		private Integer age;
		private String address;
		private String gender;

		public Builder setSeq(Long seq) {
			this.seq = seq;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(Integer age) {
			this.age = age;
			return this;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder setGender(String gender) {
			this.gender = gender;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

}

class Member {

	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;

	public Member(Long seq, String name, Integer age, String address, String gender) {
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [seq=" + seq + ", name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender
				+ "]";
	}
}
