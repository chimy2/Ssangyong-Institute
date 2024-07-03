package com.test.question.classproblem;

public class Note  {
	private String size = "A5";		//크기
	private String color = "흰색";	//표지 색상
	private int page = 10;			//페이지수
	private String owner;			//소유자이름
	private int price = 500;		//가격
	
	//setter, getter 구현
	
	public void setSize(String size) {
		String[] sizes = { "A3", "A4", "A5", "B3", "B4", "B5" };
		int[] prices = { 400, 200, 0, 500, 300, 100 };
		
		for(int i=0; i<sizes.length; i++) {
			if(size.equals(sizes[i])) {
				this.size = size;
				this.price += prices[i];
				break;
			}
		}
	}

	public void setColor(String color) {
		String[] colors = { "검정색", "흰색", "노란색", "파란색" };
		int[] prices = { 100, 0, 200, 200 };
		
		for(int i=0; i<colors.length; i++) {
			if(color.equals(colors[i])) {
				this.color = color;
				this.price += prices[i];
				break;
			}
		}
	}

	public void setPage(int page) {
		if(page < 10 || page > 200) {
			return;
		}
		this.price += Math.abs(page - this.page) * 10;
		this.page = page;
	}

	public void setOwner(String owner) {
		int len = owner.length();
		if(len < 2 || len > 5 || !isAllKorean(owner)) {
			return;
		}
		this.owner = owner;
	}

	private boolean isAllKorean(String owner) {
		for(int i=0; i<owner.length(); i++) {
			char c = owner.charAt(i);
			if(c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}

	public String info() {
		String result = "";
		result += "■■■■■■ 노트 정보 ■■■■■■\n";
		if(this.owner == null) {
			result += "주인 없는 노트\n";
		} else {
			result += String.format("소유자 : %s\n", this.owner);
			result += String.format("특성 : %s\n", getProperty(this.color, this.page, this.size));
			result += String.format("가격 : %,d원\n", this.price);
		}
		result += "■■■■■■■■■■■■■■■■■■■■■■\n\n";
		return result;
	}

	private String getProperty(String color, int page, String size) {
		String result = "";
		result += this.color + " ";
		result += calcPage(this.page) + " ";
		result += this.size + "노트";
		return result;
	}

	private String calcPage(int page) {
		if(page <= 50) {
			return "얇은";
		} else if(page <= 100) {
			return "보통인";
		}
		return "두꺼운";
	}
}
