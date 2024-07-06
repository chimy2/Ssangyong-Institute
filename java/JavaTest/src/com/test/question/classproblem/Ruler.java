package com.test.question.classproblem;

public class Ruler {
	private int length;
	private String shape;
	
	public void setLength(int length) {
		this.length = length;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public int getLength() {
		return length;
	}

	public String getShape() {
		return shape;
	}

	String info() {
		if(length == 0 || shape == null) {
			return "잘못된 자입니다.";
		}
		return String.format("%dcm %s입니다.", this.length, this.shape);
	}
	
}
