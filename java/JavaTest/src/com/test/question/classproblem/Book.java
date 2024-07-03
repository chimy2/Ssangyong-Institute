package com.test.question.classproblem;

public class Book {
	private String title = "";			//제목
	private int price;					//가격
	private String author;				//저자
	private String publisher;			//출판사
	private String pubYear = "2019";	//발행년도
	private String isbn;				//ISBN
	private int page = 1;				//페이지수
	
	//getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
//		🌟🌟🌟 유효성 검사
//		- 올바르지 않은 것을 찾아라!!
		
		if(title.length() > 50) {
//			빈 리턴문(아무것도 돌려주지 않는다.)
//			메서드 종료 역할
			return;
		}
		for(int i=0; i<title.length(); i++) {
			if(!isCorrectLetter(title.charAt(i))) {
				return;
			}
		}
		this.title = title;
	}
	
	public boolean isCorrectLetter(char letter) {
		if(letter == ' ' || letter >= '0' && letter <= '9'
				|| letter >= 'A' && letter <= 'Z'
				|| letter >= 'a' && letter <= 'z'
				|| letter >= '가' && letter <= '힣') {
			return true;
		}
		return false;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0 || price > 1000000) {
			return;
		}
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubYear() {
		return pubYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page < 1) {
			return;
		}
		this.page = page;
	}

	public String info() {
		String result = "";
		result += String.format("제목: %s\n", this.title);
		result += String.format("가격: %,d원\n", this.price);
		result += String.format("저자: %s\n", this.author);
		result += String.format("출판사: %s\n", this.publisher);
		result += String.format("발행년도: %s년\n", this.pubYear);
		result += String.format("ISBN: %s\n", this.isbn);
		result += String.format("페이지: %,d장\n", this.page);
		return result;
	}
}
