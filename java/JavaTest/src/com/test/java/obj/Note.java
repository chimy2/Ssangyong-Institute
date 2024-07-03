package com.test.java.obj;

public class Note {
	private String color;
	private int pages;
	private int price = 1000;
	
//	color > Setter	
	public void setColor(String color) {
		this.color = color;
	}
	
//	color > Getter > X

//	Getter만 구현 > 읽기 전용 프로퍼티
	public int getPrice() {
		return price;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
//	가상 프로퍼티, 계산된 프로퍼티 
//	> 실제로 존재하는 멤버를 조절하는게 아님, 실제 멤버를 가공해서 만들어 냄
	public String getType() {
		if(this.pages <= 10) {
			return "얇은 노트";
		} else if(this.pages <= 50) {
			return "보통 노트";
		} else {
			return "두꺼운 노트";
		}
	}
}
