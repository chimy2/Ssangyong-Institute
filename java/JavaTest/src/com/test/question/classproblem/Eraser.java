package com.test.question.classproblem;

public class Eraser {
	private String size;

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}

	String info() {
		if(size == null) {
			return "잘못된 지우개입니다.";
		}
		return String.format("%s 진하기 연필입니다.", this.size);
	}
	
}
