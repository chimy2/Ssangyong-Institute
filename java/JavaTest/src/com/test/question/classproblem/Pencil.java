package com.test.question.classproblem;

public class Pencil {
	private String hardness;

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	
	public String getHardness() {
		return hardness;
	}

	String info() {
		if(hardness == null) {
			return "잘못된 연필입니다.";
		}
		return String.format("%s 진하기 연필입니다.", this.hardness);
	}
	
}
