package com.test.java.obj;

public class Book {
	public String title;
	private int price;	//왜?
//	public int price;
	
	private String publisher;
	private String author;
	private int discount;
	private int pages;
	
	
//	aaa() > setPrice() > Setter
//	- set키워드 + 멤버변수명 > 캐멀 표기법
	public void setPrice(int price) {
		this.price = price;
		
//		this > 객체 접근 연산자
//		this.title="";	//올바른 표현(FM)
//		title="";	//잘못된 표현
	}
	
//	bbb() > getPrice() > Getter
//	- get키워드 + 멤버변수명 > 캐멀표기법
	public int getPrice() {
		return this.price;
	}
	
	public void aaa(int a) {
//		변수 자체를 오픈하면 무지성으로 설정할 수 있으나 
//		메소드로 변경하게 하면 개입할 수 있는 여지가 생긴다
//		개입 가능 > 통제 가능
		if(a >= 0 && a <= 100000) {
			price = a;
		}
	}
	
	public int bbb() {
		return price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
