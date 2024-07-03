package com.test.java.obj;

public class Parent {
	private String name;
	private int age;
	
//	private Child child;
//	상위 개념의 Class가 하위 개념의 Class를 참조하면
//	객체 생성 순서에 있어서 어긋나게 됨
	
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
